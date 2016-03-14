import spock.lang.Specification

/**
 * Created by romina on 14.03.2016.
 */
class SummerSpec extends Specification {
    def summer

    void setup(){
        summer=new Summer()
    }

    void "test summer functions"(){
        expect:
        assert 2 == summer.sumWithDefaults(1,1)
        assert 3 == summer.sumWithDefaults(1,1,1)
        assert 2 == summer.sumWithList([1,1])
        assert 3 == summer.sumWithList([1,1,1])
        assert 2 == summer.sumWithOptionals(1,1)
        assert 3 == summer.sumWithOptionals(1,1,1)
        assert 2 == summer.sumNamed(a:1, b:1)
        assert 3 == summer.sumNamed(a:1, b:1, c:1)
        assert 1 == summer.sumNamed(c:1)
    }

}
