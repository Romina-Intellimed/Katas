package todolist

import grails.transaction.Transactional

@Transactional
class ToDoItemService {

    def save(toDoItemId, toDoItemData) {
        def toDoItemInstance = ToDoItem.findById(toDoItemId)
        toDoItemInstance.properties = toDoItemData
        toDoItemInstance.save(failOnError: true)
    }
}
