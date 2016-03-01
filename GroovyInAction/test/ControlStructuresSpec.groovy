import spock.lang.Specification

/**
 * Created by romina on 29.02.2016.
 */
class ControlStructuresSpec extends Specification {

    void "test while loops"() {
        given:
        def list = [1, 2, 3]

        when:
        while (list) {
            list.remove(0)
        }
        then:
        assert list == []

        when:
        while (list.size() < 3) list << list.size() + 1

        then:
        assert list == [1, 2, 3]

    }
}
