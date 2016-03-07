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


    def createListOfItems() {
        List listOfItems = []
        listOfItems.add(new ToDoItem(name: "A", startDate: new Date(), endDate: new Date(), priority: PriorityType.HIGH, remindDate: new Date()).save(failOnError: true))
        listOfItems.add(new ToDoItem(name: "B", startDate: new Date(), endDate: new Date(), priority: PriorityType.NORMAL, remindDate: new Date()).save(failOnError: true))
        listOfItems.add(new ToDoItem(name: "C", startDate: new Date(), endDate: new Date(), priority: PriorityType.LOW, remindDate: new Date()).save(failOnError: true))
        listOfItems.add(new ToDoItem(name: "AC", startDate: new Date(), endDate: new Date(), priority: PriorityType.LOW, remindDate: new Date()).save(failOnError: true))
        listOfItems.add(new ToDoItem(name: "BC", startDate: new Date(), endDate: new Date(), priority: PriorityType.LOW, remindDate: new Date()).save(failOnError: true))
        return listOfItems
    }

    void "search return the items with name like given word"() {
        given:
        def listOfItems = createListOfItems()
        def entry = "A"

        when:
        def actuallistOfItems = service.search(entry)

        then:
        assert actuallistOfItems.size() == 1
        assert actuallistOfItems.get(0).name == "A"
    }

    void "search return empty list if there is no item name like given word"() {
        given:
        createListOfItems()
        def entry = "D"

        when:
        def listOfItems = service.search(entry)

        then:
        assert listOfItems.size() == 0
    }

    void "sort_ByName returns an ordered list by name"() {
        given:
        createListOfItems()
        when:
        def listOfItems = service.sort_byName()
        then:
        assert listOfItems.get(0).name == 'A'
        assert listOfItems.get(1).name == 'AC'
        assert listOfItems.get(2).name == 'B'
        assert listOfItems.get(3).name == 'BC'
        assert listOfItems.get(4).name == 'C'
    }


    void "sort_ByStartDate returns an ordered list by startDate"() {
        given:
        createListOfItems()
        when:
        def listOfItems = service.sort_byStartDate()
        then:
        assert listOfItems.get(0).name == 'A'
        assert listOfItems.get(1).name == 'B'
        assert listOfItems.get(2).name == 'C'
        assert listOfItems.get(3).name == 'AC'
        assert listOfItems.get(4).name == 'BC'
    }


    void "sort_ByEndDate returns an ordered list by endDate"() {
        given:
        createListOfItems()
        when:
        def listOfItems = service.sort_byEndDate()
        then:
        assert listOfItems.get(0).name == 'A'
        assert listOfItems.get(1).name == 'B'
        assert listOfItems.get(2).name == 'C'
        assert listOfItems.get(3).name == 'AC'
        assert listOfItems.get(4).name == 'BC'
    }

    void "sort_ByRemindDate returns an ordered list by remindDate"() {
        given:
        createListOfItems()
        when:
        def listOfItems = service.sort_byRemindDate()
        then:
        assert listOfItems.get(0).name == 'A'
        assert listOfItems.get(1).name == 'B'
        assert listOfItems.get(2).name == 'C'
        assert listOfItems.get(3).name == 'AC'
        assert listOfItems.get(4).name == 'BC'
    }
}
