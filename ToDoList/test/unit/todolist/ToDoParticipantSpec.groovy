package todolist

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ToDoParticipant)
class ToDoParticipantSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test toString"() {
        when: "a toDo Participant has a name"
        def toDoParticipant=new ToDoParticipant(name: "Julian Blin")
        then: "the toString method will display name"

        toDoParticipant.toString()=="Julian Blin"
    }

    void "a toDoParticipant with non empty name is valid"() {
        given:
        def toDoParticipant=new ToDoParticipant(name: "Julian Blin")

        expect:
        toDoParticipant.validate()
    }

    void "a toDoParticipant with no name is invalid"() {
        given:
        def toDoParticipant=new ToDoParticipant()

        expect:
        toDoParticipant.validate() == false
    }

    void "a toDoParticipant with no email address is valid"() {
        given:
        def toDoParticipant=new ToDoParticipant(name: "Default")

        expect:
        toDoParticipant.validate() == true
    }

}
