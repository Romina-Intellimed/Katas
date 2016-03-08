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
        buildRequestParams(participant)

        when:
        controller.addNew()
        def actualItem = ToDoItem.findByName(controller.params.name)

        then:
        participant == actualItem.participants.get(0)
    }
    
    private void buildRequestParams(participant) {
        controller.params.name = "name"
        controller.params.participants = [participant.id.toString()]
    }

    void "user can create a new to do item with multiple participants"() {

    }

    void "user can add more participants to an existing to do item"() {

    }

    void "user can add one participant to an existing to do item"() {

    }
}
