import org.junit.Before;
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
    public void theGameisInPlayingState(){
        testGame.run();

        assertTrue(testGame.state=="PLAYING");

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

        assertEquals(testGame.players.get(0),testGame.getGameWinner());
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
        testGame.players.get(0).score=4;
        testGame.players.get(1).score=4;

        testGame.updateGameState();

        assertTrue(testGame.state=="DEUCE");


    }

    @Test
    public void gameEndsWhenOnePlayerHasTheMaximumScoreGreaterThanTheOpponent() {
        //todo
    }


    /// game in deuce, the winner of the ball has advantage and game ball
    @Test
    public void thePlayerHasAdvantage(){
        testGame.state="DEUCE";
        //testGame.getBallWinner().hasAdvantage=true;


    }

    @Test
    public void theGameIsInAdvantageState(){

    }

    @Test
    public void thePlayerWithAdvantageWinsTheBall(){

    }

    @Test
    public void theGameIsInEndState(){


    }


    @Test
    public void thePlayerWithAdvantageLostsTheBall(){

    }

    @Test
    public void theGameIsInDeuceAfterPlayerWithAdvantageLostsTheBall(){

    }



}
