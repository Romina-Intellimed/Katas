package todolist

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ToDoParticipantController)
@Mock([ToDoParticipant])
class ToDoParticipantControllerSpec extends Specification {

    def setup() {
        controller.toDoParticipantService = Mock(ToDoParticipantService)
    }

    def cleanup() {
    }

    void "test something"() {
    }


    void "add calls corresponding service method"() {

        when:
        controller.addNew()

        then:
        1 * controller.toDoParticipantService.addNew(*_)
    }

    void "add calls corresponding service method with the right params"() {
        given:
        requestParamsReceived()
        def expectedToParticipantData = buildExpectedToDoParticipnatData()

        when:
        controller.addNew()

        then:
        1 * controller.toDoParticipantService.addNew(expectedToParticipantData)
    }

    private buildExpectedToDoParticipnatData() {
        def expectedToDoParticipantData = [:]
        expectedToDoParticipantData.name = params.name
        expectedToDoParticipantData.emailAddress = params.emailAddress
        expectedToDoParticipantData.age = params.age
        expectedToDoParticipantData
    }

    private void requestParamsReceived() {
        params.id = "22"
        params.name = "name"
        params.emailAddress = "email@domain.com"
        params.age = 23

    }

}
