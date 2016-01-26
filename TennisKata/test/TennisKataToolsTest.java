import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

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
    public void shouldReturnRandomPlayer(){
        List<Player> inputPlayersList=new ArrayList<>();
        inputPlayersList.add(new Player("player-test-1"));
        inputPlayersList.add(new Player("player-test-2"));

        Player expectedPlayer1Output=inputPlayersList.get(0);
        Player expectedPlayer2Output=inputPlayersList.get(1);

        Player actualPlayerOuput=tools.randomPlayer(inputPlayersList);


        assertEquals(expectedPlayer1Output + " or " + expectedPlayer2Output+ " should be " + actualPlayerOuput, expectedPlayer1Output, actualPlayerOuput); //???


    }


    @Test
    public void shouldWinTheBall(){
        Boolean inputValue=true;
        String expectedResult="Wins the ball";


        String actualResult=tools.isWinTheBall(inputValue);

        assertEquals("for input " +inputValue + " should be the same with " + actualResult, expectedResult, actualResult);


    }




}
