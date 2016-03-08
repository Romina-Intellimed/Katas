package todolist

import grails.transaction.Transactional

@Transactional
class ToDoParticipantService {

    def serviceMethod() {

    }



    def addNew(toDoParticipantData) {
        def toDoParticipantInstance = new ToDoParticipant()
        toDoParticipantInstance.properties = toDoParticipantData
        toDoParticipantInstance.save(failOnError: true)
    }
}
