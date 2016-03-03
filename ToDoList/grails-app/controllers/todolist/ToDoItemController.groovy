package todolist

import grails.transaction.Transactional

class ToDoItemController {

    def index() {
        return [helloString: "In Show ToDoList page", todoListItems: ToDoItem.findAll()]
    }

    def create() {
    }

    def addNew() {
        def newItemName = params.itemName
        def newItemDescription = params.itemDescription
        def newItemLocation = params.itemLocation
        def newItemStartDate = params.itemStartDate
        def newItemEndDate = params.itemEndDate
        def newItemRepeat = params.itemRepeat
        def newItemRemindDate = params.itemRemindDate
        def newItemPriority = params.itemPriority

        new ToDoItem(name: newItemName, description: newItemDescription, location: newItemLocation, startDate: newItemStartDate, endDate: newItemEndDate,
                repeat: newItemRepeat, remindDate: newItemRemindDate, priority: newItemPriority).save(failOnError: true)

        redirect action: "index"
    }


    def show(Long id) {
        def toDoItemInstance = ToDoItem.findById(id)
        if (!toDoItemInstance) {
            redirect(action: "index")
        }
        [toDoItemInstance: toDoItemInstance]
    }


    def edit(Long id) {
        def toDoItemInstance = ToDoItem.findById(id)
        if (!toDoItemInstance) {
            redirect(action: "index")
        }
        [toDoItemInstance: toDoItemInstance]
    }

    @Transactional
    def save() {
        println(params)
        def toDoItemInstance = ToDoItem.findById(params.id)
        toDoItemInstance.setName(params.name)
        toDoItemInstance.setDescription(params.description)
        toDoItemInstance.setLocation(params.location)
        toDoItemInstance.setStartDate(params.startDate)
        toDoItemInstance.setEndDate(params.endDate)
        toDoItemInstance.setRepeat(params.repeat ? true : false)
        toDoItemInstance.setRemindDate(params.remindDate)
        toDoItemInstance.setPriority(PriorityType.valueOf(params.priority))
        toDoItemInstance.save(failOnError: true)
        redirect action: "index"

    }

    def search() {

        def itemsContainingWord = ToDoItem.findAllByNameIlike("${params.entry}%")

        if (!itemsContainingWord) {
            redirect(action: "index")
        }
        [itemsContainingWord: itemsContainingWord]
    }

    def delete(Long id) {
        def toDoItemInstace = ToDoItem.findById(id)
        toDoItemInstace.delete(flush: true)

        redirect(action: "index")
    }


    def sort_byName() {
        def todoListItems = ToDoItem.findAll().sort { it.name }
        renderIndex(todoListItems)
    }

    private renderIndex( todoListItems) {

        render view: "index", model: [helloString: "In Show ToDoList page", todoListItems: todoListItems]
    }

    def sort_byStartDate() {
        def todoListItems = ToDoItem.findAll().sort { it.startDate }
        renderIndex(todoListItems)
    }

    def sort_byEndDate() {
        def todoListItems = ToDoItem.findAll().sort { it.endDate }
        renderIndex(todoListItems)
    }

    def sort_byRemindDate() {
        def todoListItems = ToDoItem.findAll().sort { it.remindDate }
        renderIndex(todoListItems)
    }



}
