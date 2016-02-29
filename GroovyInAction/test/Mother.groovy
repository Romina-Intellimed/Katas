/**
 * Created by romina on 29.02.2016.
 */
class Mother {
    def prop = 'prop'

    def method() { 'method' }

    Closure birth(param) {
        def local = 'local'
        def closure = {
            [this, prop, method(),local, param]
        }
        return closure
    }

    public def foo(n) {
        return { n += it }
    }
}