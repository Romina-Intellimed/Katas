import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Romina DRUTA on 25.01.2016.
 */
public class PlayGameTest {

    private PlayGame playerGameTest;

    @Before
    public void setup() {
        playerGameTest = new PlayGame(new Player("test-1"),new Player("test-2"));

    }

    @Test
    public void dummyTest() {
        assert true;
    }


    @Test
    public void startGameShouldEnd(){

        String expectedOutput="END";
        String actualOutput=playerGameTest.startGame();

        assertEquals("Game should " +expectedOutput,actualOutput, expectedOutput);

    }




}
