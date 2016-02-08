/**
 * Created by romina on 08.02.2016.
 */
class FizzBuzz {

    def printResult(inputNumber)   {
        if(inputNumber=="")
            throw  new IllegalInputException("The input should not be empty")
        if(inputNumber<0)
            throw new IllegalInputException("The input should be a positive number")
        if(inputNumber instanceof String)
            throw new IllegalInputException("The input should be a positive number")

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
