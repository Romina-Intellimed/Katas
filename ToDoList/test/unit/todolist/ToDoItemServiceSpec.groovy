package todolist

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.validation.ValidationException
import spock.lang.FailsWith
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ToDoItemService)
@Mock([ToDoItem])
class ToDoItemServiceSpec extends Specification {
    def id
    def todoItemData

    def setup() {
        id = 22
        todoItemData = buildToDoItemData()
    }

    def cleanup() {
    }

    void "save updates properties of item with given id"() {
        given:
        def todoItem = new ToDoItem(name: "initial name").save(failOnError: true)

        when:
        def actualToDoItem = service.save(todoItem.id, todoItemData)

        then:
        todoItemData.name == actualToDoItem.name
        todoItemData.description == actualToDoItem.description
        todoItemData.location == actualToDoItem.location
        todoItemData.startDate == actualToDoItem.startDate
        todoItemData.endDate == actualToDoItem.endDate
        todoItemData.repeat == actualToDoItem.repeat
        todoItemData.remindDate == actualToDoItem.remindDate
        todoItemData.priority == actualToDoItem.priority
    }

    private def buildToDoItemData() {
        def toDoItemData = [:]
        toDoItemData.name = "new name"
        toDoItemData.description = "description"
        toDoItemData.location = "location"
        toDoItemData.startDate = new Date()
        toDoItemData.endDate = new Date()
        toDoItemData.repeat = true
        toDoItemData.remindDate = new Date()
        toDoItemData.priority = PriorityType.NORMAL
        toDoItemData
    }

    @FailsWith(ValidationException)
    void "save fails when received name is null"() {
        given:
        def todoItem = new ToDoItem(name: "initial name").save(failOnError: true)
        todoItemData.name = null

        when:
        def actualToDoItem = service.save(todoItem.id, todoItemData)

        then:
        assert actualToDoItem == todoItem
    }


    void "does not update an inexistant item"() {
        given:
        def todoItem = new ToDoItem()
        when:

        def actualToDoItem = service.save(todoItem.id, todoItemData)

        then:
        assert actualToDoItem == null
    }

    void "add adds a new item"() {
        when:
        def actualToDoItem = service.addNew(todoItemData)

        then:
        assert actualToDoItem.id != null
        assert actualToDoItem.name == todoItemData.name
        assert actualToDoItem.description == todoItemData.description
        assert actualToDoItem.location == todoItemData.location
        assert actualToDoItem.startDate == todoItemData.startDate
        assert actualToDoItem.endDate == todoItemData.endDate
        assert actualToDoItem.repeat == todoItemData.repeat
        assert actualToDoItem.remindDate == todoItemData.remindDate
        assert actualToDoItem.priority == todoItemData.priority

    }

    @FailsWith(ValidationException)
    void "add fails when received name is null"() {
        given:
        todoItemData.name = null
        when:
        def actualToDoItem = service.addNew(todoItemData)
        then:
        assert actualToDoItem == null
    }


    void "delete deletes an item with a given id"() {
        given:
        def actualToDoItem = service.addNew(todoItemData)

        when:
        service.delete(actualToDoItem.id)

        then:
        assert ToDoItem.findById(actualToDoItem.id) == null

    }


    void "show returns a ToDoItem Instance for a given id"() {
        given:
        def toDoItem = service.addNew(todoItemData)
        when:
        def actualToDoItemInstance = service.show(toDoItem.id)
        then:
        assert actualToDoItemInstance.name == toDoItem.name
        assert actualToDoItemInstance.description == toDoItem.description
        assert actualToDoItemInstance.startDate == toDoItem.startDate
        assert actualToDoItemInstance.endDate == toDoItem.endDate
        assert actualToDoItemInstance.priority == toDoItem.priority
        assert actualToDoItemInstance.remindDate == toDoItem.remindDate
        assert actualToDoItemInstance.repeat == toDoItem.repeat
    }

    void "show return null if given id does not exist"() {
        when:
        def actualToDoItemInstance = service.show(id)
        then:
        actualToDoItemInstance == null
    }


    void "edit returns a ToDoItem Instance for a given id"() {
        given:
        def toDoItem = service.addNew(todoItemData)
        when:
        def actualToDoItemInstance = service.edit(toDoItem.id)
        then:
        assert actualToDoItemInstance.name == toDoItem.name
        assert actualToDoItemInstance.description == toDoItem.description
        assert actualToDoItemInstance.startDate == toDoItem.startDate
        assert actualToDoItemInstance.endDate == toDoItem.endDate
        assert actualToDoItemInstance.priority == toDoItem.priority
        assert actualToDoItemInstance.remindDate == toDoItem.remindDate
        assert actualToDoItemInstance.repeat == toDoItem.repeat
    }

    void "edit return null if given id does not exist"() {
        when:
        def actualToDoItemInstance = service.edit(id)
        then:
        actualToDoItemInstance == null
    }


}
