package training.names;

/**
 * Created by Romina DRUTA on 12.01.2016.
 */
public class ConversionRomanToNumeral {

    boolean isValidRomanNumber(String romanNumber) {
        int indexLetter = 0;
        Boolean assertValue = false;
        if (romanNumber == null || romanNumber.length() == 0) {
            assertValue = false;
        } else {
            while (indexLetter < romanNumber.length()) {
                char romanLetter = romanNumber.charAt(indexLetter);
                indexLetter++;
                if (RomanNumeralsMap.getCorrespondingNumberforRomanDigit(romanLetter) != null)
                    assertValue = true;
                else
                    assertValue = false;
            }
        }
        return assertValue;
    }


    public Integer romanToNumeral(String romanNumber) {
        if (!isValidRomanNumber(romanNumber)) throw new IllegalArgumentException("Bad roman number");

        Integer numeral = 0;
        int indexLetter = 0;
        while (indexLetter < romanNumber.length()) {

            Integer currentNumber = getValueForLetterWithIndex(indexLetter, romanNumber);

            indexLetter++;

            if (isEndOfRomanNumber(indexLetter, romanNumber)) {
                numeral = addCurrentValueToNumber(numeral, currentNumber);
                break;
            } else {
                Integer nextNumber = getValueForLetterWithIndex(indexLetter, romanNumber);

                if (isSubstractionGroup(currentNumber, nextNumber)) {
                    numeral = addCurrentValueToNumber(numeral, (nextNumber - currentNumber));
                    indexLetter++;
                } else {
                    numeral = addCurrentValueToNumber(numeral, currentNumber);
                }
            }
        }
        return numeral;
    }

    private Integer addCurrentValueToNumber(Integer numeral, Integer currentNumber) {
        numeral += currentNumber;
        return numeral;
    }

    private boolean isSubstractionGroup(Integer currentNumber, Integer nextNumber) {
        return nextNumber > currentNumber;
    }


    private boolean isEndOfRomanNumber(Integer indexLetter, String romanNumber) {
        return indexLetter == romanNumber.length();
    }

    private Integer getValueForLetterWithIndex(Integer indexLetter, String romanNumber) {
        char currentLetter = romanNumber.charAt(indexLetter);
        return RomanNumeralsMap.getCorrespondingNumberforRomanDigit(currentLetter);
    }


}
