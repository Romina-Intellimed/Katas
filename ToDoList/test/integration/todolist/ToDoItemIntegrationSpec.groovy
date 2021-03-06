package todolist

import grails.test.spock.IntegrationSpec

class ToDoItemIntegrationSpec extends IntegrationSpec {

    def controller

    void setup() {
        controller = new ToDoItemController()
    }

    def cleanup() {
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
        participant == actualItem.participants.first()
    }


    void "user can create a new to do item with multiple participants"() {
        given:
        def participantsList=addParticipantsToList()
        buildRequestParams(participantsList)

        when:
        controller.addNew()
        def actualItem = ToDoItem.findByName(controller.params.name)

        then:
        participantsList == actualItem.participants.sort()
    }

    private void buildRequestParams(participantsList) {
        controller.params.name = "name"
        def list = []
        participantsList.forEach {
            list.add(it.id)
        }
        controller.params.participants = list
    }

    private def addParticipantsToList(){
        def participantsList = []
        def participant1 = ToDoParticipant.list()[0]
        def participant2 = ToDoParticipant.list()[1]
        participantsList.add(participant1)
        participantsList.add(participant2)
        participantsList.sort()
        return participantsList
    }

    void "user can add more participants to an existing to do item"() {
        given:
        def toDoItem=ToDoItem.findByName("Learn Groovy")
        def participantsList = addParticipantsToList()
        buildRequestParams(participantsList)
        controller.params.id=toDoItem.id

        when:
        controller.save()
        def actualItem = ToDoItem.findById(controller.params.id)

        then:
        participantsList == actualItem.participants.sort()
    }

    void "user can add one participant to an existing to do item"() {
        given:
        def toDoItem=ToDoItem.findByName("Learn Groovy")
        def participantsList = [ToDoParticipant.list()[0]]
        buildRequestParams(participantsList)
        controller.params.id=toDoItem.id

        when:
        controller.save()
        def actualItem = ToDoItem.findById(controller.params.id)

        then:
        participantsList[0] == actualItem.participants.first()
    }
}
