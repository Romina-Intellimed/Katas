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

}
