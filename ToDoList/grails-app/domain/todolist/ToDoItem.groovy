package todolist


class ToDoItem {

    String name
    String description
    Date startDate
    Date endDate
    Boolean repeat
    String location
    Date remindDate
    PriorityType priority

    static hasMany = [participants:ToDoParticipant]

    static constraints = {
        description nullable: true
        startDate nullable: true
        endDate nullable: true
        repeat nullable: true
        location nullable: true
        remindDate nullable: true
        priority nullable: true
        participants nullable: true
    }

    String toString(){
        "$name, $description"
    }

}
