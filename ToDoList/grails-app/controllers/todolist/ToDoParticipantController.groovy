package todolist

class ToDoParticipantController {
    def toDoParticipantService
    def index() {}

    def create(){

    }
    def addNew() {
        def toDoParticipantData=[:]

        toDoParticipantData.name = params.name
        toDoParticipantData.emailAddress = params.emailAddress
        toDoParticipantData.age = params.age

        toDoParticipantService.addNew(toDoParticipantData)
// de ce nu e toDoItemController ?
        redirect (controller: "toDoItem", action: "index")
    }
}
