import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by Romina DRUTA on 25.01.2016.
 */
public class TennisKataToolsTest {

    private TennisKataTools tools;

    @Before
    public void setup() {
        tools = new TennisKataTools();
    }

    @Test
    public void dummyTest() {
        assert true;
    }


    @Test
    public void shouldReturnRandomPlayerFromPlayersList(){
        List<Player> inputPlayersList=new ArrayList<>();
        inputPlayersList.add(new Player("player-test-1"));
        inputPlayersList.add(new Player("player-test-2"));


        Player actualPlayerOuput=tools.randomPlayer(inputPlayersList);
        Boolean isInPlayersList=inputPlayersList.contains(actualPlayerOuput);

        assertTrue(isInPlayersList);

    }


    @Test
    public void shouldWinTheBall(){
        Boolean inputValue=true;
        String expectedResult="Wins the ball";


        String actualResult=tools.isWinTheBall(inputValue);

        assertEquals("for input " +inputValue + " should be the same with " + actualResult, expectedResult, actualResult);


    }

    @Test
    public void shouldLooseTheBall(){
        Boolean inputValue=false;
        String expectedResult="Lost the ball";


        String actualResult=tools.isWinTheBall(inputValue);

        assertEquals("for input " +inputValue + " should be the same with " + actualResult, expectedResult, actualResult);


    }



}
