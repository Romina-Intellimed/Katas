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

    def setup() {
    }

    def cleanup() {
    }

    void "save updates properties of item with given id"() {
        given:
        def todoItem = new ToDoItem(name: "initial name").save(failOnError: true)
        def todoItemData = buildToDoItemData()
        
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
    void "save fails when received name is null"(){
        given:
        def todoItem=new ToDoItem(name:"initial name").save(failOnError: true)
        def todoItemData=buildToDoItemData()
        todoItemData.name=null

        when:
        def actualToDoItem=service.save(todoItem.id,todoItemData)

        then:
        assert actualToDoItem == todoItem
    }


    void "does not update an inexistant item"(){
        given:
        def todoItem=new ToDoItem()
        def todoItemData=buildToDoItemData()
        when:

        def actualToDoItem=service.save(todoItem.id,todoItemData)

        then:
        assert actualToDoItem == null
    }

    void "add adds a new item"(){
        given:
        def todoItemData = buildToDoItemData()

        when:
        def actualToDoItem = service.addNew(todoItemData)

        then:
        assert  actualToDoItem.id !=null

    }



}
