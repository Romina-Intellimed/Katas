/**
 * Created by romina on 08.02.2016.
 */
class FizzBuzz {

    def printResult(int inputNumber) {
        if (isDivisibleByThree(inputNumber) && !isDivisibleByFive(inputNumber))
           return  "Fizz"
        if (isDivisibleByFive(inputNumber) && !isDivisibleByThree(inputNumber))
            return "Buzz"
        if((isDivisibleByFive(inputNumber) && isDivisibleByThree(inputNumber)))
            return "FizzBuzz"
        return inputNumber.toString()

    }

    private boolean isDivisibleByFive(int inputNumber) {
        inputNumber % 5 == 0
    }

    private boolean isDivisibleByThree(int inputNumber) {
        inputNumber % 3 == 0
    }

}
