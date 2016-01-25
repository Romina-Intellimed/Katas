package training.names;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Romina DRUTA on 25.01.2016.
 */
public class ConversionNumeralToRomanTests {


    private ConversionNumeralToRoman converter;

    @Before
    public void setup() {
        converter = new ConversionNumeralToRoman();
    }

    @Test
    public void dummyTest() {
        assert true;
    }

    // To check with C.
    @Test
    public void shouldThrowExceptionIfInvalidNumeral(){
        Integer input = 55555;
        Boolean expectedOutput = false;

        Boolean actualOutput = converter.assertNumeralInLimits(input);

        assertEquals(input + " respects the given limits " + actualOutput, expectedOutput, actualOutput);

    }



    @Test
    public void givenNumberIsInLimits(){
        Integer input = 567;
        Boolean expectedOutput = true;

        Boolean actualOutput = converter.assertNumeralInLimits(input);

        assertEquals(input + " respects the given limits " + actualOutput, expectedOutput, actualOutput);

    }


    @Test
    public void oneShouldBEConvertedToI(){
        Integer input = 1;
        String expectedOutput = "I";

        String actualOutput = converter.numeralToRoman(input);

        assertEquals(input + " should be converted to " + actualOutput, expectedOutput, actualOutput);

    }



    @Test
    public void twoShouldBEConvertedToII(){
        Integer input = 2;
        String expectedOutput = "II";

        String actualOutput = converter.numeralToRoman(input);

        assertEquals(input + " should be converted to " + actualOutput, expectedOutput, actualOutput);


    }



    @Test
    public void fourShouldBEConvertedToIV(){
        Integer input = 4;
        String expectedOutput = "IV";

        String actualOutput = converter.numeralToRoman(input);

        assertEquals(input + " should be converted to " + actualOutput, expectedOutput, actualOutput);

    }

    @Test
    public void nineShouldBEConvertedToIX(){
        Integer input = 9;
        String expectedOutput = "IX";

        String actualOutput = converter.numeralToRoman(input);

        assertEquals(input + " should be converted to " + actualOutput, expectedOutput, actualOutput);

    }





}
