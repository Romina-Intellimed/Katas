package todolist


class ToDoItemController {

    def toDoItemService

    def index() {
        def toDoItems=toDoItemService.getToDoItems()
        return [toDoListItems: toDoItems]
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
        toDoItemData.participant=toDoItemService.getParticipant(params.participant)
        toDoItemService.addNew(toDoItemData)

        redirect action: "index"
    }


    def show(Long id) {
        def toDoItemInstance = toDoItemService.show(id)
        if (!toDoItemInstance) {
            redirect(action: "index")
        }
        [toDoItemInstance: toDoItemInstance]
    }


    def edit(Long id) {
        def toDoItemInstance = toDoItemService.edit(id)
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
        toDoItemData.participant=toDoItemService.getParticipant(params.participant)
        toDoItemData.priority = params.priority
        toDoItemService.save(params.id, toDoItemData)
        redirect action: "index"

    }

    def delete(Long id) {
        toDoItemService.delete(id)
        redirect(action: "index")
    }


    def search() {

        def itemsContainingWord = toDoItemService.search("${params.entry}%")

        if (!itemsContainingWord) {
            redirect(action: "index")
        }
        [itemsContainingWord: itemsContainingWord]
    }



    def sort_byName() {
        def todoListItems=toDoItemService.sort_byName()
        renderIndex(todoListItems)
    }


    def sort_byStartDate() {
        def todoListItems=toDoItemService.sort_byStartDate()
        renderIndex(todoListItems)
    }

    def sort_byEndDate() {
        def todoListItems=toDoItemService.sort_byEndDate()
        renderIndex(todoListItems)
    }

    def sort_byRemindDate() {
        def todoListItems=toDoItemService.sort_byRemindDate()
        renderIndex(todoListItems)
    }

    private renderIndex( todoListItems) {
        render view: "index", model: [helloString: "In Show ToDoList page", toDoListItems: todoListItems]
    }


}
