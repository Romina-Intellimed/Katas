import todolist.PriorityType
import todolist.ToDoItem
import todolist.ToDoParticipant

class BootStrap {

    def init = { servletContext ->
        def participant1 = new ToDoParticipant(name: "Jake Bond", emailAdress: "jake.bond@msn.com", age: 45).save(failOnError: true)
        def participant2 = new ToDoParticipant(name: "James Sawyer", emailAddress: "james.sawyer@gmail.com", age: 22).save(failOnError: true)
        def participant3 = new ToDoParticipant(name: "Billy Blancs", emailAddress: "billy.blancs@yahoo.com", age: 32).save(failOnError: true)

        def item1 = new ToDoItem(name: "Learn Grails", description: "Read and practice",  startDate: new Date(), endDate: new Date(), remindDate: new Date(), location: "Mozaik", priority: PriorityType.HIGH, repeat: true).save(failOnError: true)
        def item2 = new ToDoItem(name: "Learn Groovy", description: "Read and practice",  startDate: new Date(), endDate: new Date(), remindDate: new Date(), location: "Mozaik", priority: PriorityType.HIGH, repeat: true).save(failOnError: true)
        item1.addToParticipants(participant1).addToParticipants(participant2).addToParticipants(participant3)
        item2.addToParticipants(participant2)
    }
    def destroy = {
    }
}
