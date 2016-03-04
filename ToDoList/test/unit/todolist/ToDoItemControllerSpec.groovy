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

    def setup() {
        controller.toDoItemService = Mock(ToDoItemService)

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
        controller.toDoItemService = Mock(ToDoItemService)
        when:
        controller.delete(id)
        then:
        1 * controller.toDoItemService.delete(*_)
    }

    void "test delete called with tight params calls corresponding service method"() {
        given:
        Long id = 22
        controller.toDoItemService = Mock(ToDoItemService)
        when:
        controller.delete(id)
        then:
        1 * controller.toDoItemService.delete(id)
    }

}
