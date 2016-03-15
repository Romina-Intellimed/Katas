/**
 * Created by romina on 15.03.2016.
 */
class MrBean {
    String firstName, lastName
    public value

    String getName(){
        return "$firstName $lastName"
    }

    void setValue(value){
        this.value=value
    }
    def getValue(){
        value*2
    }

}
