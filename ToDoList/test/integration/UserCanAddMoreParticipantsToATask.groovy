import grails.test.spock.IntegrationSpec
import org.codehaus.groovy.grails.support.ParticipatingInterceptor
import todolist.PriorityType
import todolist.ToDoItem
import todolist.ToDoItemController
import todolist.ToDoParticipant

/**
 * Created by romina on 08.03.2016.
 */
class UserCanAddMoreParticipantsToAToDoItemSpec extends IntegrationSpec {

    def controller

    void setup() {
        controller = new ToDoItemController()
    }

    void "user can create a new to do item with one participant"() {
        given:
        def participant = ToDoParticipant.list()[0]
        def participantsList = []
        participantsList.add(participant)
        buildRequestParams(participantsList)

        when:
        controller.addNew()
        def actualItem = ToDoItem.findByName(controller.params.name)

        then:
        participant == actualItem.participants.get(0)
    }


    void "user can create a new to do item with multiple participants"() {
        given:
        def participantsList = []
        def participant1 = ToDoParticipant.list()[0]
        def participant2 = ToDoParticipant.list()[1]
        participantsList.add(participant1)
        participantsList.add(participant2)
        buildRequestParams(participantsList)

        when:
        controller.addNew()
        def actualItem = ToDoItem.findByName(controller.params.name)

        then:
        participantsList == actualItem.participants
    }

    private void buildRequestParams(participantsList) {
        controller.params.name = "name"
        def list = []
        participantsList.forEach {
            list.add(it.id)
        }
        controller.params.participants = list
    }

    void "user can add more participants to an existing to do item"() {
        given:
        def participantsList = []
        def participant1 = ToDoParticipant.list()[0]
        def participant2 = ToDoParticipant.list()[1]
        participantsList.add(participant1)
        participantsList.add(participant2)
        buildRequestParams(participantsList)

        when:
        controller.save()
        def actualItem = ToDoItem.findByName(controller.params.name)

        then:
        participantsList == actualItem.participants
    }

    void "user can add one participant to an existing to do item"() {
        given:
        def participant = ToDoParticipant.list()[0]
        def participantsList = []
        participantsList.add(participant)
        buildRequestParams(participantsList)

        when:
        controller.save()
        def actualItem = ToDoItem.findByName(controller.params.name)

        then:
        participant == actualItem.participants.get(0)
    }
}
