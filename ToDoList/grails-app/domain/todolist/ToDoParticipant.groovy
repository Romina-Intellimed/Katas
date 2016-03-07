package todolist

class ToDoParticipant {

    String name
    Integer age
    String emailAdress
    static constraints = {
        age nullable: true
        emailAdress nullable: true
    }
}
