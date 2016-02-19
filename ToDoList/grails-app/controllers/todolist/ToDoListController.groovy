package todolist

class ToDoListController {



    def index() {
        return [helloString: "In Show ToDoList page", todoListItems: ToDoItem.list(), learnGrailsItem: ToDoItem.findByNameLike("Learn Grails").name]
    }
}
