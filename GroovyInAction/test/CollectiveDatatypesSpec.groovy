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
        assert myList == ['a', 'b']
        assert myList - 'b' == ['a']
        assert myList * 2 == ['a', 'b', 'a', 'b']
    }


    void "test control structures"() {
        given:
        myList = ['a', 'b', 'c']
        def expr = ''

        expect:
        assert myList.isCase('a')
        assert 'b' in myList


        when:
        def candidate = 'c'

        then:
        switch (candidate) {
            case myList: assert true; break
            default: assert false
        }
        assert ['x', 'a', 'z'].grep(myList) == ['a']

        when:
        myList = []
        then:
        if (myList) assert false

        when:
        for (i in [1, '*', 5]) {
            expr += i
        }
        then:
        assert expr == '1*5'

    }

    void "test map"() {
        given:
        def myMap = [a: 1, b: 2, c: 3]
        def emptyMap = [:]
        def explicitMap = new TreeMap()
        explicitMap.putAll(myMap)
        def composed = [x: 'y', *: myMap]

        expect:
        assert myMap instanceof LinkedHashMap
        assert myMap.size() == 3
        assert myMap['a'] == 1
        assert emptyMap.size() == 0
        assert explicitMap['a'] == 1
        assert composed == [x: 'y', a: 1, b: 2, c: 3]
    }

    void "test querry methods on maps"() {
        given:
        def myMap = [a: 1, b: 2, c: 3]
        def other = [b: 2, c: 3, a: 1]
        expect:
        assert myMap == other
        assert !myMap.isEmpty()
        assert myMap.size() == 3
        assert myMap.containsKey('a')
        assert myMap.containsValue(1)
        assert myMap.entrySet() instanceof Collection

        assert myMap.any { entry -> entry.value > 2 }

        assert myMap.every { entry -> entry.key < 'd' }
        assert myMap.keySet() == ['a', 'b', 'c'] as Set
        assert myMap.values().toList() == [1, 2, 3]
    }


    void "iterating over maps"() {
        given:
        def myMap = [a: 1, b: 2, c: 3]
        def store = ''

        when:
        myMap.each { entry ->
            store += entry.key
            store += entry.value
        }
        then:
        assert store == 'a1b2c3'

        when:
        store = ''
        myMap.each { key, value ->
            store += key
            store += value

        }
        then:
        assert store == 'a1b2c3'

        when:
        store = ''
        for (key in myMap.keySet()) {
            store += key
        }
        then:
        assert store == 'abc'


        when:
        store = ''
        for (value in myMap.values()) {
            store += value
        }
        then:
        assert store == "123"

    }


    void "test change map empty content"() {
        given:
        def myMap = [a: 1, b: 2, c: 3]
        when:
        myMap.clear()
        then:
        assert myMap.isEmpty()


    }

    void "test remove from map"() {
        given:
        def myMap = [a: 1, b: 2, c: 3]
        when:
        myMap.remove('a')
        then:
        assert myMap.size() == 2
        assert [a: 1] + [b: 2] == [a: 1, b: 2]
    }


    void "test create a view into original map"() {
        given:
        def myMap = [a: 1, b: 2, c: 3]
        def abMap = myMap.subMap(['a', 'b'])
        expect:
        assert abMap.size() == 2

        when:
        abMap = myMap.findAll { entry -> entry.value < 3 }
        then:
        assert abMap.size() == 2
        assert abMap.a == 1

        when:
        def found = myMap.find { entry -> entry.value < 2 }
        then:
        assert found.key == 'a'
        assert found.value == 1


        when:
        def doubled = myMap.collect { entry -> entry.value *= 2 }
        then:
        assert doubled instanceof List
        assert doubled.every { item -> item % 2 == 0 }

        when:
        def addTo = []
        myMap.collect(addTo) { entry -> entry.value *= 2 }
        then:
        assert addTo instanceof List
        assert addTo.every { item -> item % 2 == 0 }

    }

}
