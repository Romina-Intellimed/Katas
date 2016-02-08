/**
 * Created by romina on 08.02.2016.
 */
class InputValidator {

    static void validateInput(inputNumber) {
        if (inputNumber == "")
            throw new IllegalInputException("The input should not be empty")
        if (inputNumber < 0)
            throw new IllegalInputException("The input should be a positive number")
        if (inputNumber instanceof String)
            throw new IllegalInputException("The input should be a positive number")
        if (inputNumber > 100)
            throw new IllegalInputException("The input should be a positive number smaller than 100")
    }
}
