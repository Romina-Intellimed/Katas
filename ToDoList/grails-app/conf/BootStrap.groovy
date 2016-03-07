import todolist.PriorityType
import todolist.ToDoItem
import todolist.ToDoParticipant

class BootStrap {

    def init = { servletContext ->
        new ToDoItem(name: "Learn Grails",description: "Read and practice",startDate: new Date(),endDate: new Date(),remindDate: new Date(), location: "Mozaik",priority: PriorityType.HIGH,repeat: true).save(failOnError: true)
        new ToDoItem(name: "Learn Groovy",description: "Read and practice",startDate: new Date(),endDate: new Date(),remindDate: new Date(), location: "Mozaik",priority: PriorityType.HIGH,repeat: true).save(failOnError: true)
        new ToDoParticipant(name: "Jake Bond",emailAdress: "jake.bond@msn.com",age: 45)
        new ToDoParticipant(name: "James Sawyer",emailAdress: "james.sawyer@gmail.com",age: 22)
        new ToDoParticipant(name: "Billy Blancs",emailAdress: "billy.blancs@yahoo.com",age: 32)
    }
    def destroy = {
    }
}
