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
        assert 'medium' == words.find(sizeUpTo6)
        assert 'short' == words.find(filter5.&sizeUpTo)
    }


    void curryingTest() {

        given:
        def configurator = { format, filter, line ->
            filter(line) ? format(line) : null

        }

        def appender = { config, append, line ->
            def out = config(line)
            if (out) append out
        }

        def dateFormatter = { line -> "${new Date()}:$line" }
        def debugFilter = { line -> line.contains('debug') }
        def consoleAppender = { line -> println line }

        def myConf = configurator.curry(dateFormatter, debugFilter)
        def myLog = appender.curry(myConf, consoleAppender)

        myLog('here is some debug message')
        myLog('this will not be printed')
    }

    void "test closure scope"() {
        given:
        Mother julia = new Mother()
        def closure = julia.birth('param')

        when:
        def context = closure.call()

        then:
        assert context[0] == julia
        assert context[1, 2] == ['prop', 'method']
        assert context[3, 4] == ['local', 'param']

        assert closure.thisObject == julia
        assert closure.owner == julia
        assert closure.delegate == julia
        assert closure.resolveStrategy == Closure.OWNER_FIRST

    }


    void "test accumulations"() {

        given:
        Mother motherAccumulators=new Mother()

        when:
        def accumulator = motherAccumulators.foo(1)

        then:
        assert accumulator(2) == 3
        assert accumulator(1) == 4
    }

}
