import org.junit.Before;
import org.junit.Ignore;
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


    /*
    Test cases
    1. Game is not in deuce and one player has a score greater than the other
    2. Both players have equal scores - game was in deuce
    3.Start game should end with a winner and the score is valid, and game state should be END - test the game state, players state & score state

     */

    // this test tests only that the return is END
    @Test
    public void startGameShouldEnd(){

        playerGameTest.startGame();

        assertCorrectScore();
        assertGameEnded();
        assertPlayerState();
    }


    private void assertPlayerState() {
    //TODO

    }
    private void assertGameEnded() {
    //TODO

    }

    private void assertCorrectScore() {
    //TODO

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
    @Ignore
    //TODO Fix this
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


    @Test
    public void gameShouldBeDeuceWhenScoresEqualFortyAndPlayersHaveNoAdvantage(){
        playerGameTest.player1.score=TennisKataGameRules.FORTY;
        playerGameTest.player2.score=TennisKataGameRules.FORTY;
        playerGameTest.player1.hasAdvantage=false;
        playerGameTest.player2.hasAdvantage=false;

        Boolean expectedResult=true;

        Boolean actualRestult=playerGameTest.isDeuce();

        assertEquals("Game should be in deuce: "+actualRestult  ,expectedResult, actualRestult);


    }

    @Test
    public void gameShouldBeInAdvantage(){
        playerGameTest.player1.hasAdvantage=true;
        playerGameTest.player2.hasAdvantage=true;


        Boolean expectedResult=true;

        Boolean actualRestult=playerGameTest.isAdvantage();

        assertEquals("Game should be in Advantage: "+actualRestult  ,expectedResult, actualRestult);

    }




}
