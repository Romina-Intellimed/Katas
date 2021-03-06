import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
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

        Player winner = playerGameTest.run();


        assertGameEnded();
        assertWinnerExists(winner);
        assertWinnerHasCorrectScore(winner);
    }

    private void assertWinnerHasCorrectScore(Player winner) {
        Player looser = getLooser(winner);
        assertTrue((winner.getScore() == TennisKataGameRules.FORTY && looser.getScore() < winner.getScore()) ||
                (winner.getScore() == TennisKataGameRules.FORTY && looser.getScore() == winner.getScore() && winner.hasAdvantage && winner.winTheBall && !looser.hasAdvantage && !looser.winTheBall));
    }

    private Player getLooser(Player winner) {
        for(Player currentPlayer: playerGameTest.playersList) {
            if (currentPlayer != winner) {
                return currentPlayer;
            }
        }
        return TennisKataTools.noPlayer;
    }

    private void assertWinnerExists(Player winner) {
        assertTrue(playerGameTest.playersList.contains(winner));
    }

    @Test
    public void playerStateIsUpdatedCorrectlyWhenPlayerGainsAdvantage() {
        Player actualWinner=playerGameTest.player1;
        playerGameTest.player1.score = TennisKataGameRules.FORTY;
        playerGameTest.player2.score = TennisKataGameRules.FORTY;

        playerGameTest.player1.hasAdvantage=false;
        playerGameTest.player2.hasAdvantage=false;

        playerGameTest.updatePlayersAdvantageState(actualWinner);

        assertTrue(actualWinner.hasAdvantage.equals(true));
        assertTrue(actualWinner.hasGameBall.equals(true));

    }


    @Test
    public void playerStateIsUpdatedCorrectlyWhenPlayerLoosesAdvantage() {
        Player actualWinner=playerGameTest.player1;
        playerGameTest.player1.score = TennisKataGameRules.FORTY;
        playerGameTest.player2.score = TennisKataGameRules.FORTY;

        playerGameTest.player1.hasAdvantage=false;
        playerGameTest.player2.hasAdvantage=true;

        playerGameTest.updatePlayersAdvantageState(actualWinner);

        assertTrue(actualWinner.hasGameBall.equals(false));

    }


    private void assertGameEnded() {
        Assert.assertEquals(GameState.END, playerGameTest.getGameState());

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
    public void getGameWinnerShouldBeAPlayerWithHighestScore(){

        playerGameTest.player1.score = TennisKataGameRules.FORTY;
        playerGameTest.player2.score =TennisKataGameRules.FIFTEEN;
        playerGameTest.player1.winTheBall = true;
        Player actualWinner=playerGameTest.getGameWinner();
        Boolean isInList=playerGameTest.playersList.contains(actualWinner);

        assertTrue(isInList);

    }


    @Test
    public void getGameWinnerShouldBeAPlayerWithAdvantageWhoWinsTheBall(){

        playerGameTest.player1.hasAdvantage = true;
        playerGameTest.player1.winTheBall = true;
        Player actualWinner=playerGameTest.getGameWinner();
        Boolean isInList=playerGameTest.playersList.contains(actualWinner);

        assertTrue(isInList);

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
