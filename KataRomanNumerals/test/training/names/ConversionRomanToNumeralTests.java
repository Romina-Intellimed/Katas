package training.names;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

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
        assert true == true;
    }

    @Test
    public void IshouldConvertTo1() {
        String input = "I";
        Integer expectedOutput = 1;

        Integer actualOutput = converter.romanToNumeral(input);

        Assert.assertEquals(input + " is converted to " + actualOutput, expectedOutput, actualOutput);
    }



    @Test
    public void XshouldCOnvertTo10(){
        String input = "X";
        Integer expectedOutput=10;

        Integer actualOutput=converter.romanToNumeral(input);

        Assert.assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }



}
