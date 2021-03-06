import spock.lang.FailsWith
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
        expect:
        "Fizz" == fizzBuzz.printResult(12)

    }


    void "for 15 return FizzBuzz"() {
        expect:
        "FizzBuzz" == fizzBuzz.printResult(15)

    }

    void "for 18 return Fizz"() {
        expect:
        "Fizz" == fizzBuzz.printResult(18)
    }

    void "for 20 return Buzz"() {
        expect:
        "Buzz" == fizzBuzz.printResult(20)
    }

    void "for 30 return FizzBuzz"() {
        expect:
        "FizzBuzz" == fizzBuzz.printResult(30)
    }

    void "for 90 return FizzBuzz"() {
        expect:
        "FizzBuzz" == fizzBuzz.printResult(90)
    }

    @FailsWith(IllegalInputException)
    void "for empty string return error input should not be empty"() {
        expect:
        fizzBuzz.printResult("")
    }

    @FailsWith(IllegalInputException)
    void "for negative number return error input is a positive number"() {
        expect:
        fizzBuzz.printResult(-1)
    }

    @FailsWith(IllegalInputException)
    void "for string input return error input should be a number"() {
        expect:
        fizzBuzz.printResult("1")

    }
    @FailsWith(IllegalInputException)
    void "for number bigger than 100 return error input should be smaller than 100"() {
        expect:
        fizzBuzz.printResult(300)
    }


}
