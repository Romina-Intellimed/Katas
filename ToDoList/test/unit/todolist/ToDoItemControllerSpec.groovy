package todolist

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ToDoItemController)
@Mock([ToDoItem])
class ToDoItemControllerSpec extends Specification {
    Long id
    def setup() {
        controller.toDoItemService = Mock(ToDoItemService)
        id = 22
    }

    def cleanup() {
    }

    void "index returns empty list when no to do items"() {
        when:
        def actualListItems = controller.index().todoListItems

        then:
        assert [] == actualListItems
    }

    void "index returns list with all created toDoItems"() {
        given:
        def todoItem = new ToDoItem(name: "something").save()
        def todoItem2 = new ToDoItem(name: "something 2").save()

        when:
        def actualListItems = controller.index().todoListItems

        then:
        assert [todoItem, todoItem2] == actualListItems
    }

    void "test index returns model"() {
        when:
        def toDoItemModel = controller.index()
        then:
        assert "In Show ToDoList page" == toDoItemModel.helloString
        assert [] == toDoItemModel.todoListItems

    }

    void "sort_byName renders corresponding view"() {
        when:
        controller.sort_byName()
        then:
        assert "/toDoItem/index" == view

    }


    void "sort_byName renders corresponding model"() {
        given:
        controller.toDoItemService.sort_byName()>>[]
        when:
        controller.sort_byName()
        then:
        assert [] == model.todoListItems

    }

    void "save calls corresponding service method"() {
        given:
        params.priority = "NORMAL"

        when:
        controller.save()

        then:
        1 * controller.toDoItemService.save(*_)
    }

    void "save calls corresponding service method with the right params"() {
        given:
        requestParamsReceived()
        def expectedToDoItemData = buildExpectedToDoItemData()

        when:
        controller.save()

        then:
        1 * controller.toDoItemService.save(params.id, expectedToDoItemData)
    }


    void "add calls corresponding service method"() {

        when:
        controller.addNew()

        then:
        1 * controller.toDoItemService.addNew(*_)
    }

    void "add calls corresponding service method with the right params"() {
        given:
        requestParamsReceived()
        def expectedToDoItemData = buildExpectedToDoItemData()

        when:
        controller.addNew()

        then:
        1 * controller.toDoItemService.addNew(expectedToDoItemData)
    }

    private buildExpectedToDoItemData() {
        def expectedToDoItemData = [:]
        expectedToDoItemData.name = params.name
        expectedToDoItemData.description = params.description
        expectedToDoItemData.location = params.location
        expectedToDoItemData.startDate = params.startDate
        expectedToDoItemData.endDate = params.endDate
        expectedToDoItemData.repeat = params.repeat
        expectedToDoItemData.remindDate = params.remindDate
        expectedToDoItemData.priority = params.priority
        expectedToDoItemData
    }

    private void requestParamsReceived() {
        params.id = "22"
        params.name = "name"
        params.description = "description"
        params.location = "location"
        params.startDate = new Date()
        params.endDate = new Date()
        params.repeat = true
        params.remindDate = new Date()
        params.priority = PriorityType.NORMAL
    }


    void "test delete calls corresponding service method"() {
        given:
        def id = params.id
        when:
        controller.delete(id)
        then:
        1 * controller.toDoItemService.delete(*_)
    }

    void "test delete called with tight params calls corresponding service method"() {
        when:
        controller.delete(id)
        then:
        1 * controller.toDoItemService.delete(id)
    }

    void "test delete calls redirects to the right page"(){
        when:
        controller.delete(id)

        then:
        response.redirectedUrl == "/toDoItem/index"
    }


    void "test show called with tight params calls corresponding service method"() {
        when:
        controller.show(id)
        then:
        1 * controller.toDoItemService.show(id)
    }

    void "test show called of inexistant item redirect to the right page"(){
        when:
        controller.show(id)
        then:
        response.redirectedUrl == "/toDoItem/index"
    }

    void "test show called with existant item id returns the right model"(){
        given:
        def toDoItemInstance = new ToDoItem(name:"default")
        controller.toDoItemService.show(*_) >> toDoItemInstance
        when:
        def actualShowModel=controller.show(0)
        then:
        toDoItemInstance==actualShowModel.toDoItemInstance
    }





    void "test edit called with tight params calls corresponding service method"() {
        when:
        controller.edit(id)
        then:
        1 * controller.toDoItemService.edit(id)
    }

    void "test edit calls corresponding service method"(){
        given:
        def id = params.id
        when:
        controller.edit(id)
        then:
        1 * controller.toDoItemService.edit(*_)
    }

    void "test search calls corresponding service method"(){
        when:
        controller.search()
        then:
        1*controller.toDoItemService.search(*_)

    }


    void "test sortByName calls correponding service method"(){
        when:
        controller.sort_byName()
        then:
        1*controller.toDoItemService.sort_byName()
    }


    void "test sortByStartDate calls correponding service method"(){
        when:
        controller.sort_byStartDate()
        then:
        1*controller.toDoItemService.sort_byStartDate()
    }


    void "test sortByEndDate calls correponding service method"(){
        when:
        controller.sort_byEndDate()
        then:
        1*controller.toDoItemService.sort_byEndDate()
    }


    void "test sortByRemindDate calls correponding service method"(){
        when:
        controller.sort_byRemindDate()
        then:
        1*controller.toDoItemService.sort_byRemindDate()
    }



}
