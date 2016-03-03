package todolist

import grails.transaction.Transactional

class ToDoItemController {

    def toDoItemService

    def index() {
        return [helloString: "In Show ToDoList page", todoListItems: ToDoItem.findAll()]
    }

    def create() {
    }

    def addNew() {
        def toDoItemData=[:]

        toDoItemData.name = params.itemName
        toDoItemData.description = params.itemDescription
        toDoItemData.location = params.itemLocation
        toDoItemData.startDate = params.itemStartDate
        toDoItemData.endDate = params.itemEndDate
        toDoItemData.repeat = params.itemRepeat
        toDoItemData.remindDate = params.itemRemindDate
        toDoItemData.priority = params.itemPriority

        toDoItemService.addNew(toDoItemData)
/*
        new ToDoItem(name: newItemName, description: newItemDescription, location: newItemLocation, startDate: newItemStartDate, endDate: newItemEndDate,
                repeat: newItemRepeat, remindDate: newItemRemindDate, priority: newItemPriority).save(failOnError: true)
*/

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

    def save() {
        def toDoItemData = [:]
        toDoItemData.name = params.name
        toDoItemData.description = params.description
        toDoItemData.location = params.location
        toDoItemData.startDate = params.startDate
        toDoItemData.endDate = params.endDate
        toDoItemData.repeat = params.repeat ? true : false
        toDoItemData.remindDate = params.remindDate
        toDoItemData.priority = PriorityType.valueOf(params.priority)
        toDoItemService.save(params.id, toDoItemData)
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
       def todoListItems=ToDoItem.list(sort:'name')
        renderIndex(todoListItems)
    }

    private renderIndex( todoListItems) {
        render view: "index", model: [helloString: "In Show ToDoList page", todoListItems: todoListItems]
    }

    def sort_byStartDate() {
        def todoListItems=ToDoItem.list(sort:'startDate')
        renderIndex(todoListItems)
    }

    def sort_byEndDate() {
        def todoListItems=ToDoItem.list(sort:'endDate')
        renderIndex(todoListItems)
    }

    def sort_byRemindDate() {
        def todoListItems=ToDoItem.list(sort:'remindDate')
        renderIndex(todoListItems)
    }



}
