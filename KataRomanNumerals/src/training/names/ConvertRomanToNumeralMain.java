package training.names;

/**
 * Created by Romina DRUTA on 07.01.2016.
 */
public class ConvertRomanToNumeralMain {


    public static void main(String[] args) {
        String romanNumber="CXVIII";
        ConversionRomanToNumeral romanToNumeralObj = new ConversionRomanToNumeral();
        try {
            System.out.println("Roman " + romanNumber + " to numeral: " + romanToNumeralObj.romanToNumeral(romanNumber));
        }catch (IllegalArgumentException excetion){
            System.out.println(excetion.toString());
        }

    }

}



