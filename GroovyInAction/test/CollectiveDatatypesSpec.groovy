import spock.lang.Specification

/**
 * Created by romina on 24.02.2016.
 */
class CollectiveDatatypesSpec extends Specification {

    List myList
    def setup() {
        myList = [1, 2, 3]
    }


    void "test list with elements"() {
        expect:
        assert myList.size() == 3
        assert myList[0] == 1
        assert myList instanceof ArrayList
    }

    void "test empty list"() {
        when:
        List emptyList = []
        then:
        assert emptyList.size() == 0

    }

    void "test other type of lists"(){
        when:
        List longList=(0..1000).toList()
        List explicitList=new ArrayList()
        explicitList.addAll(myList)
        explicitList[0]=10


        then:
        assert longList[555]==555
        assert explicitList.size()==3
        assert explicitList[0]==10


        when:
        explicitList=new LinkedList(myList)
        explicitList[0]=10
        then:
        assert explicitList.size()==3
        assert explicitList[0]==10

    }

}
