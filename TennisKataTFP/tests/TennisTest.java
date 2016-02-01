import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by romina on 28.01.2016.
 */
public class TennisTest {

    Game testGame;

    @Before
    public void setup(){
        testGame=new Game();

    }


    @Test
    public void theGamesHasTwoPlayers(){

        assertTrue(testGame.players.size()==2);

    }

    @Test
    public void theGameisInStartState(){

        assertTrue(testGame.state=="START");

    }


    @Test
    public void gameEndsWhenOnePlayerHasTheMaximumScoreGreaterThanTheOpponent() {

        testGame.run();

        assertTrue(testGame.winner.score > testGame.looser.score);
        assertTrue(testGame.winner.score==4);
        assertEquals(testGame.state,"END");

    }



    @Test
    public void thePlayerWinsPointsWhenPlayerWinsTheBall(){
        Integer winnerScore=testGame.players.get(0).getScore()+1;


        testGame.playerScores(testGame.players.get(0));
        assertEquals((winnerScore), testGame.players.get(0).getScore());

    }


    @Test
    public void winnerWhenOnePlayerHasTheMaximumScoreGreaterThanTheOpponent(){
        testGame.players.get(0).score=4;
        testGame.players.get(1).score=2;

        testGame.updatePlayersFinalState();

        assertEquals(testGame.players.get(0),testGame.winner);
    }




    @Test
    public void theGameIsInEndStateWhenOnePlayerHasTheMaximumScoreGreaterThanTheOpponent(){
        testGame.players.get(0).score=4;
        testGame.players.get(1).score=2;

        testGame.updateGameState();

        assertTrue(testGame.state=="END");
    }



    @Test
    public void theGameIsInDeuceState(){

        testGame.runDeuce();

        assertTrue(testGame.state=="DEUCE");


    }

    @Test
    public void thePlayerAdvanatageStateIsUpdated(){
        testGame.runPlayerWithAdvantageWinsTheBall();
        assertTrue(testGame.players.get(0).hasAdvantage);

    }



    @Test

    public void theGameIsInAdvantageState(){
        testGame.players.get(0).score=4;
        testGame.players.get(1).score=4;
        testGame.players.get(0).hasAdvantage=true;

        testGame.updateGameState();


        assertTrue(testGame.state=="ADVANTAGE");

    }

    @Test
    public void thePlayerWithAdvantageWinsTheBall(){
        testGame.players.get(0).score=4;
        testGame.players.get(1).score=4;

        testGame.players.get(0).winsTheBall=true;

    }

    @Test
    public void theGameIsInEndStateWhenPlayerWinsInAdvantageFromTheFirstDeuce(){
        testGame.runPlayerWithAdvantageWinsTheBall();
        assertEquals(testGame.players.get(0),testGame.winner);
        assertWinnerScore();
        assertTrue((testGame.state=="END"));

    }

    private void assertWinnerScore() {
        assertEquals((Integer)4,testGame.winner.score);
        assertTrue(testGame.winner.hasAdvantage && !testGame.looser.hasAdvantage);
    }


    @Test
    public void theGameIsInDeuceAfterPlayerWithAdvantageLostsTheBall(){
        testGame.runPlayerWithAdvantageLostsTheBall();
        assertPlayerScoreAndAdvantageStateInDeuceAfterLoosingAdvantage();
        assertTrue((testGame.state=="DEUCE"));
    }

    private void assertPlayerScoreAndAdvantageStateInDeuceAfterLoosingAdvantage() {
        assertEquals((Integer)4,testGame.player1.score);
        assertEquals((Integer)4,testGame.player2.score);

        assertTrue(!testGame.player1.hasAdvantage && !testGame.player2.hasAdvantage);
    }


}
