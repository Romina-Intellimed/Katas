/**
 * Created by romina on 08.02.2016.
 */
class FizzBuzz {

    def printResult(inputNumber)   {
        InputValidator.validateInput(inputNumber)
        if (isDivisibleOnlyByThree(inputNumber))
           return  "Fizz"
        if (isDivisibleOnlyByFive(inputNumber))
            return "Buzz"
        if(isDivisibleByThreeAndFive(inputNumber))
            return "FizzBuzz"
        return inputNumber.toString()

    }


    private boolean isDivisibleByThreeAndFive(int inputNumber) {
        isDivisibleByFive(inputNumber) && isDivisibleByThree(inputNumber)
    }

    private boolean isDivisibleOnlyByFive(int inputNumber) {
        isDivisibleByFive(inputNumber) && !isDivisibleByThree(inputNumber)
    }

    private boolean isDivisibleOnlyByThree(int inputNumber) {
        isDivisibleByThree(inputNumber) && !isDivisibleByFive(inputNumber)
    }

    private boolean isDivisibleByFive(int inputNumber) {
        inputNumber % 5 == 0
    }

    private boolean isDivisibleByThree(int inputNumber) {
        inputNumber % 3 == 0
    }

}
