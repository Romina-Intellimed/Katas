import spock.lang.Specification

/**
 * Created by romina on 08.02.2016.
 */
class FizzBuzzGameSpec extends Specification {
    FizzBuzz fizzBuzz

    void setup() {
        fizzBuzz = new FizzBuzz();
    }

    void "for 1 return 1"() {
        given:
        def inNumber = 1

        when:
        def output = fizzBuzz.printResult(inNumber)

        then:
        "1" == output

    }

    void "for 2 return 2 "() {

        expect:
        "2" == fizzBuzz.printResult(2)
    }


    void "for 3 return Fizz"() {

        expect:
        "Fizz" == fizzBuzz.printResult(3)
    }

    void "for 4 return 4"() {

        expect:
        "4" == fizzBuzz.printResult(4)
    }

    void "for 5 return Buzz"() {
        expect:
        "Buzz" == fizzBuzz.printResult(5)
    }

    void "for 6 return Fizz"() {
        expect:
        "Fizz" == fizzBuzz.printResult(6)
    }

    void "for 7 return 7"() {
        expect:
        "7" == fizzBuzz.printResult(7)
    }

    void "for 9 return Fizz"() {
        expect:
        "Fizz" == fizzBuzz.printResult(9)
    }


    void "for 10 return Buzz"() {
        expect:
        "Buzz" == fizzBuzz.printResult(10)

    }


    void "for 12 return Fizz"() {

    }


    void "for 15 return FizzBuzz"() {

    }

    void "for 18 return Fizz"() {

    }

    void "for 20 return Buzz"() {

    }

    void "for 30 return FizzBuzz"() {

    }


    void "for empty string return error input should not be empty"() {

    }

    void "for negative number return error input is a positive number"() {

    }

    void "for string input return error input should be a number"() {

    }

    void "for number bigger than 100 return error input should be smaller than 100"() {

    }


}
