import spock.lang.Ignore
import spock.lang.Specification

/**
 * Created by romina on 27.02.2016.
 */
class MultiMethodSpec extends Specification {


    void "test multiMethod closures"() {
        given:
        MultiMethodSample instance = new MultiMethodSample()
        Closure multi = instance.&mysteryMethod

        expect:
        assert 10 == multi('string arg')
        assert 3 == multi(['list', 'of', 'values'])
        assert 14 == multi(6, 8)
    }

    void "test full closure"() {
        given:
        Map map = ['a': 1, 'b': 2]
        map.each { key, value -> map[key] = value * 2 }

        expect:
        assert map == ['a': 2, 'b': 4]

        when:
        Closure doubler = { key, value -> map[key] = value * 2 }
        map.each(doubler)
        then:
        assert map == ['a': 4, 'b': 8]

        /*when:

        def doubledMethod(entry) {
            entry.value = entry.value * 2
        }
        doubler = this.&doubleMethod
        map.each(doubler)


        then:
        assert map == ['a': 8, 'b': 16]*/
    }


    void "test calling closures"() {
        given:
        def adder = { x, y -> return x + y }

        expect:
        assert adder(4, 3) == 7
        assert adder.call(2, 6) == 8
    }


}
