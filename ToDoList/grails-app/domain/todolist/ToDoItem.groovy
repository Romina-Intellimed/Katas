package todolist

class ToDoItem {

    String name
    String description
    Date startDate
    Date endDate

    static constraints = {
        description nullable: true
        startDate nullable: true
        endDate nullable: true

    }

    String toString(){
        "$name, $description"
    }

}
