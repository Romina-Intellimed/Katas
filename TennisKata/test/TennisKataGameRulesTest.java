import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Romina DRUTA on 25.01.2016.
 */
public class TennisKataGameRulesTest {

    private TennisKataGameRules gameRules;

    @Before
    public void setup() {
        gameRules = new TennisKataGameRules();
    }

    @Test
    public void dummyTest() {
        assert true;
    }


    @Test
    public void scoreShouldBeDislayCorrectlyForLove(){
        int inputScore = gameRules.LOVE;
        String expectedOutput="0";

        String actualOutput=gameRules.displayResult(inputScore);

        assertEquals(expectedOutput+ " should be equal to " +  actualOutput, expectedOutput, actualOutput);



    }

// We should test for each IF
    @Test
    public void scoreShouldBeDislayCorrectlyForForty(){
        int inputScore = gameRules.FORTY;
        String expectedOutput="40";

        String actualOutput=gameRules.displayResult(inputScore);

        assertEquals(expectedOutput+ " should be equal to " +  actualOutput, expectedOutput, actualOutput);



    }


    @Test
    public void scoreShouldBeEmptyForBadIput(){
        int inputScore = 22;
        String expectedOutput="";

        String actualOutput=gameRules.displayResult(inputScore);

        assertEquals(expectedOutput+ " should be equal to " +  actualOutput, expectedOutput, actualOutput);



    }


}
