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
        when:
        controller.sort_byName()
        then:
        assert [] == model.todoListItems

    }

    void "save calls corresponding service method"() {
        given:
        params.priority = "NORMAL"
        controller.toDoItemService = Mock(ToDoItemService)

        when:
        controller.save()

        then:
        1*controller.toDoItemService.save(*_)
    }
    
    void "save calls corresponding service method with the right params"() {
        given:
        controller.toDoItemService = Mock(ToDoItemService)
        saveRequestParamsReceived()
        def expectedToDoItemData = buildExpectedToDoItemDataForSave()

        when:
        controller.save()
        
        then:
        1*controller.toDoItemService.save(params.id, expectedToDoItemData)
    }

    private void buildExpectedToDoItemDataForSave() {
        def expectedToDoItemData = [:]
        expectedToDoItemData.name = params.name
        expectedToDoItemData.description = params.description
        expectedToDoItemData.location = params.location
        expectedToDoItemData.startDate = params.startDate
        expectedToDoItemData.endDate = params.endDate
        expectedToDoItemData.repeat = true
        expectedToDoItemData.remindDate = params.remindDate
        expectedToDoItemData.priority = PriorityType.NORMAL
        expectedToDoItemData
    }

    private void saveRequestParamsReceived() {
        params.id = "22"
        params.name = "name"
        params.description = "description"
        params.location = "location"
        params.startDate = new Date()
        params.endDate = new Date()
        params.repeat = "on"
        params.remindDate = new Date()
        params.priority = "NORMAL"
    }
}
