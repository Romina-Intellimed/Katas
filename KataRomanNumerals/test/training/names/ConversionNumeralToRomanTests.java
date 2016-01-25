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


    @Test
    public void number567IsInLimits(){
        Integer input = 567;
        Boolean expectedOutput = true;

        Boolean actualOutput = converter.assertNumeralInLimits(input);

        assertEquals(input + " respects the given limits " + actualOutput, expectedOutput, actualOutput);


    }


    



}
