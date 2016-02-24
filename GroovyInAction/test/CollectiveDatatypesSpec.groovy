import spock.lang.Specification

/**
 * Created by romina on 24.02.2016.
 */
class CollectiveDatatypesSpec extends Specification {

    def setup(){

    }


    void "test list with elements"(){
        when:
        List myList = [1,2,3]
        then:
        assert myList.size()==3
        assert myList[0]==1
        assert myList instanceof ArrayList
    }

}
