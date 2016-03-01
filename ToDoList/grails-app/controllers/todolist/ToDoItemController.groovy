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
        def newItemDescription=params.itemDescription
        def newItemLocation=params.itemLocation
        def newItemStartDate=params.itemStartDate
        def newItemEndDate=params.itemEndDate
        def newItemRepeat=params.itemRepeat
        def newItemRemindDate=params.itemsRemindDate
        def newItemPriority=params.itemPriority

        new ToDoItem(name: newItemName, description: newItemDescription, location: newItemLocation, startDate: newItemStartDate, endDate: newItemEndDate,
        repeat: newItemRepeat, remind: newItemRemindDate, priority: newItemPriority).save(failOnError: true)
        //new ToDoItem(description: newDescription).save(failOnError: true)

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
