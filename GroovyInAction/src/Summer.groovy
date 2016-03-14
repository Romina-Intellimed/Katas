/**
 * Created by romina on 14.03.2016.
 */
class Summer {
    def sumWithDefaults(a, b, c = 0) {
        return a + b + c
    }

    def sumWithList(List args) {
        return args.inject(0) { sum, i -> sum += i }
    }

    def sumWithOptionals(a,b,Object[] optionals){
        return a+b+sumWithList(optionals.toList())
    }

    def sumNamed(Map args){
        ['a','b','c'].each {args.get(it,0)}
        return args.a+args.b+args.c
    }
}
