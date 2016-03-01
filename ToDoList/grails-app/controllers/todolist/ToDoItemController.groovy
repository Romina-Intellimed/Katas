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
        def newItemRemindDate=params.itemRemindDate
        def newItemPriority=params.itemPriority

        new ToDoItem(name: newItemName, description: newItemDescription, location: newItemLocation, startDate: newItemStartDate, endDate: newItemEndDate,
        repeat: newItemRepeat, remindDate: newItemRemindDate, priority: newItemPriority).save(failOnError: true)

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
        toDoItemInstance.setDescription(params.description)
        toDoItemInstance.setLocation(params.location)
        toDoItemInstance.setStartDate(params.startDate)
        toDoItemInstance.setEndDate(params.endDate)
//        toDoItemInstance.setRepeat(params.repeat)
        toDoItemInstance.setRemindDate(params.remindDate)
  //      toDoItemInstance.setPriority(params.priority)
        toDoItemInstance.save(failOnError: true)
        redirect action: "index"

    }

    def search(){

        def itemsContainingWord=ToDoItem.findAllByNameIlike("${params.entry}%")

        if(!itemsContainingWord){
            redirect(action: "index")
        }
        [itemsContainingWord: itemsContainingWord]
      }

    def delete(Long id){
        def toDoItemInstace=ToDoItem.findById(id)
        toDoItemInstace.delete(flush: true)

            redirect(action: "index")
    }

}
