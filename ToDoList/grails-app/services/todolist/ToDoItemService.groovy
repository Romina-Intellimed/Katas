package todolist

import grails.transaction.Transactional

@Transactional
class ToDoItemService {

    def save(toDoItemId, toDoItemData) {
        def toDoItemInstance = ToDoItem.findById(toDoItemId)
        if (toDoItemInstance != null) {
            toDoItemInstance.properties = toDoItemData
            toDoItemInstance.save(failOnError: true)
        }
    }


    def addNew(toDoItemData) {
        def toDoItemInstance = new ToDoItem()
        toDoItemInstance.properties = toDoItemData
        toDoItemInstance.save(failOnError: true)
    }


    def delete(id) {
        def toDoItemInstace = ToDoItem.findById(id)
        if (toDoItemInstace != null) {
            toDoItemInstace.delete(flush: true)
        }

    }

    def show(id) {
        def toDoItemInstace = ToDoItem.findById(id)
        if (toDoItemInstace != null)
            return toDoItemInstace
    }

    def edit(id) {
        def toDoItemInstace = ToDoItem.findById(id)
        if (toDoItemInstace != null)
            return toDoItemInstace
    }

    def search(entry) {
        def itemsContainingWord = ToDoItem.findAllByNameIlike(entry)
        if (itemsContainingWord != null)
            return itemsContainingWord
    }


    def sort_byName() {
        def todoListItems = ToDoItem.list(sort: 'name')
        return todoListItems
    }


    def sort_byStartDate() {
        def todoListItems = ToDoItem.list(sort: 'startDate')
        return todoListItems
    }

    def sort_byEndDate() {
        def todoListItems = ToDoItem.list(sort: 'endDate')
        return todoListItems
    }

    def sort_byRemindDate() {
        def todoListItems = ToDoItem.list(sort: 'remindDate')
        return todoListItems
    }


    def getParticipant(participantName){
        return ToDoParticipant.findByName(participantName)
    }
}
