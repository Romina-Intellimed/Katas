import spock.lang.Ignore
import spock.lang.Specification

/**
 * Created by romina on 26.02.2016.
 */
class ClosuresSpec extends Specification {


    @Ignore
    void "test abreviated clossures"() {
        given:
        def log = ''
        (1..10).each { counter -> log += counter }
        def logIt = ''
        (1..10).each { it -> log += it }
        expect:
        assert log == "12345678910"
        assert logIt == "12345678910"
    }


    void "test simple method closures in action"() {
        given:
        SizeFilter filter6 = new SizeFilter(limit: 6)
        SizeFilter filter5 = new SizeFilter(limit: 5)

        Closure sizeUpTo6 = filter6.&sizeUpTo

        def words = ['long string', 'medium', 'short', 'tiny']

        expect:
        assert 'medium'==words.find(sizeUpTo6)
        assert 'short'==words.find(filter5.&sizeUpTo)
    }

}
