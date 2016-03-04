package todolist

import grails.transaction.Transactional

@Transactional
class ToDoItemService {

    def save(toDoItemId, toDoItemData) {
        def toDoItemInstance = ToDoItem.findById(toDoItemId)
        if(toDoItemInstance!=null){
        toDoItemInstance.properties = toDoItemData
        toDoItemInstance.save(failOnError: true)
        }
        return toDoItemInstance
    }


    def addNew(toDoItemData){
        def toDoItemInstance=new ToDoItem()
        toDoItemInstance.properties=toDoItemData
        toDoItemInstance.save(failOnError: true)
    }


    def delete(id){
        def toDoItemInstace = ToDoItem.findById(id)
        toDoItemInstace.delete(flush: true)

    }

}
