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

        toDoItemData.name = params.name
        toDoItemData.description = params.description
        toDoItemData.location = params.location
        toDoItemData.startDate = params.startDate
        toDoItemData.endDate = params.endDate
        toDoItemData.repeat = params.repeat
        toDoItemData.remindDate = params.remindDate
        toDoItemData.priority = params.priority
        println(toDoItemData)
        toDoItemService.addNew(toDoItemData)

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
        toDoItemData.repeat = params.repeat
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
        toDoItemService.delete(id)
        redirect(action: "index")
    }


    def sort_byName() {
       def todoListItems=ToDoItem.list(sort:'name')
        renderIndex(todoListItems)
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

    private renderIndex( todoListItems) {
        render view: "index", model: [helloString: "In Show ToDoList page", todoListItems: todoListItems]
    }


}
