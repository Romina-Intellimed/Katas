package training.names;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by Romina DRUTA on 22.01.2016.
 */
public class ConversionRomanToNumeralTests {

    private ConversionRomanToNumeral converter;

    @Before
    public void setup() {
        converter = new ConversionRomanToNumeral();
    }

    @Test
    public void dummyTest() {
        assert true;
    }

    @Test
    public void IshouldConvertTo1() {
        String input = "I";
        Integer expectedOutput = 1;

        Integer actualOutput = converter.romanToNumeral(input);

        assertEquals(input + " is converted to " + actualOutput, expectedOutput, actualOutput);
    }



    @Test
    public void XshouldCOnvertTo10(){
        String input = "X";
        Integer expectedOutput=10;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }


    @Test
    public void stringWithRomanLettersShouldBeRomanNumber(){
        String input="I";
        Boolean expectedOutput=true;

        Boolean actualOutput=converter.isValidRomanNumber(input);

        assertEquals(input + " should be a string composed of roman letters: " +actualOutput,expectedOutput,actualOutput);
    }



    @Test
    public void emptyStringIsNotValidRomanNumber(){
        assertEquals("" + " should be not null: " + converter.isValidRomanNumber(""), false, converter.isValidRomanNumber(""));
    }


    @Test
    public void addingValueToActualNumber(){


    }

}
