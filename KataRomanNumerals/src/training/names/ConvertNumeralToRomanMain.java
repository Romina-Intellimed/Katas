package training.names;


public class ConvertNumeralToRomanMain {

    public static void main(String[] args) {
        Integer valueToConvert = 2265;
        ConversionNumeralToRoman numeralToRomanObj = new ConversionNumeralToRoman();
        try {
            System.out.println("Convert " + valueToConvert.toString() + " to roman: " + numeralToRomanObj.numeralToRoman(valueToConvert));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }
    }

}
