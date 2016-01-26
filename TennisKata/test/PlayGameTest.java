import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.internal.BooleanSupplier;

import javax.swing.text.StyledEditorKit;

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

    @Test
    public void gameShouldBeInPlaying(){
        playerGameTest.gameState=GameState.IS_GAME_ADVANTAGE;
        playerGameTest.countDeuce=4;

        Boolean expectedOutput=true;

        Boolean actualOutput=playerGameTest.gameIsInPlaying();

        assertEquals("Game should be in playing " +expectedOutput,actualOutput, expectedOutput);


    }


    @Test
    public void gameShouldNotBeInPlaying(){
        playerGameTest.gameState=GameState.IS_GAME_WIN;
        playerGameTest.countDeuce=4;

        Boolean expectedOutput=false;

        Boolean actualOutput=playerGameTest.gameIsInPlaying();

        assertEquals("Game should not be in playing " +expectedOutput,actualOutput, expectedOutput);


    }

    @Test
    public void getGameWinnerShouldBeAPlayer(){

        Player expectedOutput=TennisKataTools.noPlayer;
                expectedOutput=playerGameTest.playersList.get(1);

        Player actualOutput=playerGameTest.getGameWinner();
        Boolean isInList=playerGameTest.playersList.contains(actualOutput);

        assertEquals("Expected output should be in players list " +isInList,actualOutput, expectedOutput);

    }

    @Test
    public void getGameLooserShouldBeTheOtherPlayer(){
        Player playerInput=TennisKataTools.noPlayer;
                playerInput=playerGameTest.player1;

        Player expectedLooser=playerGameTest.player2;
        Player actualLooser=playerGameTest.getBallLooser(playerInput);

        assertEquals("Winner "+playerInput.getName() +" should be different than  "+actualLooser.getName() ,expectedLooser, actualLooser);

    }





}
