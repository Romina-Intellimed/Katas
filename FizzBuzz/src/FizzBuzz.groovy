/**
 * Created by romina on 08.02.2016.
 */
class FizzBuzz {

    def printResult(int inputNumber) {
        if (inputNumber % 3 == 0)
           return  "Fizz"

        if (inputNumber % 5 == 0)
            return "Buzz"

        return inputNumber.toString()

    }

}
