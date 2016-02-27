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




}
