package todolist

class ToDoItemController {
    def index() {

    }

    def create() {

    }

    def addNew() {
        def newItemName = params.itemName
        new ToDoItem(name: newItemName).save(failOnError: true)
        redirect controller: "toDoList"
    }
}
