import todolist.ToDoItem

class BootStrap {

    def init = { servletContext ->
        new ToDoItem(name: "Learn Grails").save(failOnError: true)
        new ToDoItem(name: "Learn Groovy").save(failOnError: true)
    }
    def destroy = {
    }
}
