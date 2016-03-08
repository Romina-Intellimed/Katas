package todolist

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.validation.ValidationException
import spock.lang.FailsWith
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ToDoParticipantService)
@Mock([ToDoItem,ToDoParticipant])
class ToDoParticipantServiceSpec extends Specification {

    def toDoParticipantData
    def setup() {
        toDoParticipantData=buildToDoParticipantData()
    }

    def cleanup() {
    }


    void "add adds a new participant"() {
        when:
        def actualToDoParticipant = service.addNew(toDoParticipantData)

        then:
        assert actualToDoParticipant.id != null
        assert actualToDoParticipant.name == toDoParticipantData.name
        assert actualToDoParticipant.emailAddress == toDoParticipantData.emailAddress
        assert actualToDoParticipant.age == toDoParticipantData.age

    }

    @FailsWith(ValidationException)
    void "add fails when received name is null"() {
        given:
        toDoParticipantData.name = null
        when:
        def actualToDoItem = service.addNew(toDoParticipantData)
        then:
        assert actualToDoItem == null
    }

    private def buildToDoParticipantData() {
        def toDoParticipantData = [:]
        toDoParticipantData.name = "new name"
        toDoParticipantData.emailAddress = "email@domain.com"
        toDoParticipantData.age = 23
        toDoParticipantData
    }

}
