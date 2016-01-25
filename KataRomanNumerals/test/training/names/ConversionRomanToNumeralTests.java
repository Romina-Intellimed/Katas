package training.names;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.jnlp.IntegrationService;

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
    public void shouldThrowExceptionIfInvalidRomanNumber() {
        String input = "IEW";
        Boolean expectedOutput = false;

        Boolean actualOutput = converter.isValidRomanNumber(input);

        assertEquals(input + " is not a valid number: " + actualOutput, expectedOutput, actualOutput);
    }




    @Test
    public void IshouldConvertTo1() {
        String input = "I";
        Integer expectedOutput = 1;

        Integer actualOutput = converter.romanToNumeral(input);

        assertEquals(input + " is converted to " + actualOutput, expectedOutput, actualOutput);
    }


    @Test
    public void IVshouldConvertTo4() {
        String input = "IV";
        Integer expectedOutput = 4;

        Integer actualOutput = converter.romanToNumeral(input);

        assertEquals(input + " is converted to " + actualOutput, expectedOutput, actualOutput);
    }

    @Test
    public void VshouldConvertTo5() {
        String input = "V";
        Integer expectedOutput = 5;

        Integer actualOutput = converter.romanToNumeral(input);

        assertEquals(input + " is converted to " + actualOutput, expectedOutput, actualOutput);
    }

    @Test
    public void IXshouldCOnvertTo9(){
        String input = "IX";
        Integer expectedOutput=9;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }


    @Test
    public void XshouldCOnvertTo10(){
        String input = "X";
        Integer expectedOutput=10;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }


    @Test
    public void XLshouldCOnvertTo40(){
        String input = "XL";
        Integer expectedOutput=40;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }


    @Test
    public void LshouldCOnvertTo50(){
        String input = "L";
        Integer expectedOutput=50;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }

    @Test
    public void XCshouldCOnvertTo90(){
        String input = "XC";
        Integer expectedOutput=90;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }

    @Test
    public void CLshouldCOnvertTo100(){
        String input = "C";
        Integer expectedOutput=100;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }


    @Test
    public void CDLshouldCOnvertTo400(){
        String input = "CD";
        Integer expectedOutput=400;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }


    @Test
    public void DLshouldCOnvertTo500(){
        String input = "D";
        Integer expectedOutput=500;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }


    @Test
    public void CMshouldCOnvertTo900(){
        String input = "CM";
        Integer expectedOutput=900;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }

    @Test
    public void MshouldCOnvertTo1000(){
        String input = "M";
        Integer expectedOutput=1000;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }



    @Test
    public void XLIshouldCOnvertTo41(){
        String input = "XLI";
        Integer expectedOutput=41;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }

    @Test
    public void CXLIshouldCOnvertTo141(){
        String input = "CXLI";
        Integer expectedOutput=141;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }

    @Test
    public void CXLIVshouldCOnvertTo144(){
        String input = "CXLIV";
        Integer expectedOutput=144;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }

    @Test
    public void CDXLIVshouldCOnvertTo444(){
        String input = "CDXLIV";
        Integer expectedOutput=444;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }

    @Test
    public void MCDXLIVshouldCOnvertTo1444(){
        String input = "MCDXLIV";
        Integer expectedOutput=1444;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }


    @Test
    public void CCCDXLIVshouldCOnvertTo1344(){
        String input = "CCCDXLIV";
        Integer expectedOutput=644;

        Integer actualOutput=converter.romanToNumeral(input);

        assertEquals(input + " is converted to "+actualOutput,expectedOutput,actualOutput);

    }




    @Test
    public void CMCDXLIVshouldCOnvertTo1344(){
        String input = "CMCDXLIV";
        Integer expectedOutput=1344;

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
    public void sumOf25Plus65IsActualNumber90(){
        Integer inputCurrentNumber=25;
        Integer inputNumberToAdd=65;

        Integer expectedOutput=90;

        Integer actualOutput=converter.addCurrentValueToNumber(inputCurrentNumber,inputNumberToAdd);

        assertEquals(inputCurrentNumber+"+"+inputNumberToAdd +" should be : " +actualOutput,expectedOutput,actualOutput);

    }

    @Test
    public void groupOfNumbersShouldBeSubstracted(){
        Integer inputCurrentNumber=9;
        Integer inputNextNumber=10;

        Boolean expectedOutput=true;

        Boolean actualOutput=converter.isSubstractionGroup(inputCurrentNumber,inputNextNumber);
        assertEquals(inputCurrentNumber + " should be substracted from "+inputNextNumber +actualOutput,expectedOutput,actualOutput);

    }

    @Test
    public void shouldBeEndOfRomanNumber(){
        Integer inputIndexLetter=6;
        String inputString="CDXLII";

        Boolean expectedOutput=true;

        Boolean actualOutput=converter.isEndOfRomanNumber(inputIndexLetter,inputString);
        assertEquals(inputIndexLetter + " should be last letter position in "+inputString,expectedOutput,actualOutput);

    }


    @Test
    public void shouldReturnCorrectValueForLetterWithGivenIndex(){
        Integer inputIndexLetter=2;
        String inputRomanNumber="CXX";

        Integer expectedOutput=10;

        Integer actualOutput=converter.getValueForLetterWithIndex(inputIndexLetter,inputRomanNumber);

        assertEquals(inputIndexLetter + "in "+inputRomanNumber+ " should be "+actualOutput,expectedOutput,actualOutput);
    }


}
