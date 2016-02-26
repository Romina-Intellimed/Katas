package todolist

import grails.transaction.Transactional

class ToDoItemController {

    def index() {
        def item = ToDoItem.findByNameLike("Learn Grails%")
        return [helloString    : "In Show ToDoList page", todoListItems: ToDoItem.list(),
                learnGrailsItem: item ? item?.name : "Not found"]
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
        toDoItemInstance.setName(params.name)

        toDoItemInstance.save(failOnError: true)
        redirect action: "index"

//        [toDoItemInstance:toDoItemInstance]
    }

    def search(){

        def itemsContainingWord=ToDoItem.findAllByNameIlike("${params.entry}%")

        if(!itemsContainingWord){
            redirect(action: "index")
        }
        [itemsContainingWord: itemsContainingWord]
      }



}
