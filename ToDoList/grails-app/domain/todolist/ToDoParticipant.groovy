package todolist

class ToDoParticipant {

    String name
    Integer age
    String emailAddress
    static constraints = {
        age nullable: true
        emailAddress nullable: true
    }

    String toString(){
        "$name"
    }

}
