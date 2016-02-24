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

    void "test other type of lists"() {
        when:
        List longList = (0..1000).toList()
        List explicitList = new ArrayList()
        explicitList.addAll(myList)
        explicitList[0] = 10


        then:
        assert longList[555] == 555
        assert explicitList.size() == 3
        assert explicitList[0] == 10


        when:
        explicitList = new LinkedList(myList)
        explicitList[0] = 10
        then:
        assert explicitList.size() == 3
        assert explicitList[0] == 10

    }


    void "test list operators"() {
        given:
        def myList = ['a', 'b', 'c', 'd', 'e', 'f']
        expect:
        assert myList[0..2] == ['a', 'b', 'c']
        assert myList[0, 2, 4] == ['a', 'c', 'e']


        when:
        myList[0..2] = ['x', 'y', 'z']
        then:
        assert myList == ['x', 'y', 'z', 'd', 'e', 'f']

        when:
        myList[3..5] = []
        then:
        assert myList == ['x', 'y', 'z']


        when:
        myList[1..1] = [0, 1, 2]
        then:
        assert myList == ['x', 0, 1, 2, 'z']


    }


    void "test add remove items"() {
        given:
        myList = []
        when:
        myList += 'a'
        then:
        assert myList == ['a']


        when:
        myList += ['b', 'c']
        then:
        assert myList == ['a', 'b', 'c']


        when:
        myList = []
        myList << 'a' << 'b'
        then:
        assert myList==['a','b']
        assert myList - 'b'==['a']
        assert myList*2==['a','b','a','b']
    }


}
