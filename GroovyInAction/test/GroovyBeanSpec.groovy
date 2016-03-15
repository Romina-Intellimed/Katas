import org.spockframework.compiler.model.Spec
import spock.lang.Specification

/**
 * Created by romina on 15.03.2016.
 */
class GroovyBeanSpec extends Specification {
    def bean
    def mrBean

    void setup() {
        bean = new GroovyBean()
    }

    void "test groovy bean default value"() {
        expect:
        assert 'default value' == bean.getAssigned()
    }

    void "test bean set untyped"() {
        given:
        bean.setUntyped('some value')
        expect:
        assert 'some value' == bean.getUntyped()
    }


    void "test bean set typed"() {
        given:
        bean = new GroovyBean(typed: 'another value')
        expect:
        assert 'another value' == bean.getTyped()
    }

    void "test accessors on groovy bean"() {
        given:
        mrBean=new MrBean(firstName: 'Rowan')
        mrBean.lastName='Atkinson'
        expect:
        assert 'Rowan Atkinson'==mrBean.name
    }

}
