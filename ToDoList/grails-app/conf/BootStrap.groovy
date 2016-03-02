import todolist.PriorityType
import todolist.ToDoItem

class BootStrap {

    def init = { servletContext ->
        new ToDoItem(name: "Learn Grails",description: "Read and practice",startDate: new Date(),endDate: new Date(),remindDate: new Date(), location: "Mozaik",priority: PriorityType.HIGH,repeat: true).save(failOnError: true)
        new ToDoItem(name: "Learn Groovy",description: "Read and practice",startDate: new Date(),endDate: new Date(),remindDate: new Date(), location: "Mozaik",priority: PriorityType.HIGH,repeat: true).save(failOnError: true)
    }
    def destroy = {
    }
}
