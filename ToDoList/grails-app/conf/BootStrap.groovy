import todolist.PriorityType
import todolist.ToDoItem
import todolist.ToDoParticipant

class BootStrap {

    def init = { servletContext ->
        new ToDoParticipant(name: "Jake Bond",emailAdress: "jake.bond@msn.com",age: 45).save(failOnError: true)
        new ToDoParticipant(name: "James Sawyer",emailAddress:  "james.sawyer@gmail.com",age: 22).save(failOnError: true)
        new ToDoParticipant(name: "Billy Blancs",emailAddress:  "billy.blancs@yahoo.com",age: 32).save(failOnError: true)

        new ToDoItem(name: "Learn Grails",description: "Read and practice",participant: ToDoParticipant.findByName("Jake Bond"), startDate: new Date(),endDate: new Date(),remindDate: new Date(), location: "Mozaik",priority: PriorityType.HIGH,repeat: true).save(failOnError: true)
        new ToDoItem(name: "Learn Groovy",description: "Read and practice",participant: ToDoParticipant.findByName("Billy Blancs"),startDate: new Date(),endDate: new Date(),remindDate: new Date(), location: "Mozaik",priority: PriorityType.HIGH,repeat: true).save(failOnError: true)
      }
    def destroy = {
    }
}
