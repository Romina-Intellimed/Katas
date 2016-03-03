package todolist

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ToDoItem)
class ToDoItemSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test toString"() {
        when: "a toDo item has a name and a descrption"
            def toDoItem=new ToDoItem(name: "Groovy", description: "Read Groovy in Action")
        then: "the toString method will display both name and description"

        toDoItem.toString()=="Groovy, Read Groovy in Action"
        toDoItem.getProperties()
    }
}
