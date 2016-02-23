package todolist

class ToDoItemController {
    def index() {
        return [helloString: "In Show ToDoList page", todoListItems: ToDoItem.list(), learnGrailsItem: ToDoItem.findByNameLike("Learn Grails").name]
    }

    def create() {

    }

    def addNew() {
        def newItemName = params.itemName
        new ToDoItem(name: newItemName).save(failOnError: true)
        redirect action: "index"
    }



    def show(Long id){
        def toDoItemInstance = ToDoItem.get(id)
        if(!toDoItemInstance){
            redirect(action: "index")
        }


    }

}
