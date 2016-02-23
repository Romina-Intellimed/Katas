package todolist

import grails.transaction.Transactional

class ToDoItemController {
    def index() {
        return [helloString: "In Show ToDoList page", todoListItems: ToDoItem.list(), learnGrailsItem: ToDoItem.findByNameLike("Learn Grails%").name]
    }

    def create() {

    }

    def addNew() {
        def newItemName = params.itemName
        new ToDoItem(name: newItemName).save(failOnError: true)
        redirect action: "index"
    }



    def show(Long id){
        def toDoItemInstance = ToDoItem.findById(id)
        if(!toDoItemInstance){
            redirect(action: "index")
        }
        [toDoItemInstance:toDoItemInstance]
    }


    def edit(Long id){
        def toDoItemInstance = ToDoItem.findById(id)
        if(!toDoItemInstance){
            redirect(action: "index")
        }
        [toDoItemInstance:toDoItemInstance]
    }

    @Transactional
    def save(){
        def toDoItemInstance = ToDoItem.findById(params.id)
        println( "++++++++"+params.name)
        println("+++++"+toDoItemInstance.name)
        toDoItemInstance.setName(params.name)
        println("+++++"+toDoItemInstance.name)

        toDoItemInstance.save(failOnError: true)
        redirect action: "index"

//        [toDoItemInstance:toDoItemInstance]
    }


}
