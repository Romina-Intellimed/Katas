import java.util.Arrays;


/**
 * Created by Romina DRUTA on 06.01.2016.
 */
public class RomanNumber {

    String firstNumber;
    String secondNumber;

    String romanNumbersTab[] ={"I","V","X","L","C","D","M"};

    // IV, IX, XL, XC, CD, CM


    void addRomanNumbers(String firstNumber,String secondNumber){




    }


    String transformNumber(String number){
        int index=0;
        String substituteNumber="";
        while(index<number.length()){
            char currentChar=number.charAt(index);
            index++;

            if(index==number.length()){
                substituteNumber=number;
                //  return substituteNumber;
            }
            else{
                char nextChar=number.charAt(index);
                if(compareNumbers(currentChar,nextChar)) {
                    substituteNumber += nextChar + nextChar + nextChar + nextChar;
                    index++;
                }
                else{
                    substituteNumber +=currentChar;
                }
            }
        }
        return substituteNumber;

    }


    boolean compareNumbers(char first,char second){
        System.out.println(Arrays.asList(romanNumbersTab).indexOf(first));
        System.out.println(Arrays.asList(romanNumbersTab).indexOf(second));

        if(Arrays.asList(romanNumbersTab).indexOf(first)<Arrays.asList(romanNumbersTab).indexOf(second)) {


            return true;

        }
        else
            return false;

    }

}
