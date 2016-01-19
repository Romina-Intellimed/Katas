package training.names;

/**
 * Created by Romina DRUTA on 05.01.2016.
 */
public class ConversionNumeralToRoman {

    static final int MAXIMUM_NUMERAL = 3000;
    static final int MINIMUM_NUMERAL = 1;



//take into account bad inputs and null
    boolean assertNumeralInLimits(Integer numeral) {
        
        return numeral < MINIMUM_NUMERAL || numeral >= MAXIMUM_NUMERAL;
    }


    public String numeralToRoman(Integer numeral) throws IllegalArgumentException{
        StringBuilder romanNumber = new StringBuilder();;
        if(assertNumeralInLimits(numeral)) {

            int rest = numeral;

            for (Integer nr : RomanNumeralsMap.getNumeralsList()) {
                while (rest >= nr) {
                    romanNumber.append(RomanNumeralsMap.getRoman(nr));
                    rest -= nr;
                }
            }
            return romanNumber.toString();
        }
        else throw new IllegalArgumentException("Bad numeral ");
    }




}
