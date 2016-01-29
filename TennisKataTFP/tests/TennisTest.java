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
    @Ignore
    public void theGameisInPlayingState(){
        testGame.run();
        assertTrue(testGame.state=="PLAYING");

    }


    @Test
    public void gameEndsWhenOnePlayerHasTheMaximumScoreGreaterThanTheOpponent() {
        testGame.playerScores(testGame.player1);
        testGame.playerScores(testGame.player1);
        testGame.playerScores(testGame.player1);
        testGame.playerScores(testGame.player1);
        testGame.playerScores(testGame.player2);
        testGame.run();
        assertTrue(testGame.getGameWinner()==testGame.player1);


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


    /// game in deuce, the winner of the ball has advantage and game ball
    @Test
    public void thePlayerAdvanatageStateIsUpdated(){
        testGame.players.get(0).score=4;
        testGame.players.get(1).score=4;
        testGame.players.get(0).winsTheBall=true;

        testGame.updatePlayersAdvantageState(testGame.players.get(0));

        assertTrue(testGame.players.get(0).hasAdvantage);

    }



    @Test
    public void theGameIsInAdvantageState(){
        testGame.players.get(0).score=4;
        testGame.players.get(1).score=4;
       testGame.players.get(0).winsTheBall=true;

        testGame.updatePlayersAdvantageState(testGame.players.get(0));
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
    public void theGameIsInEndState(){


    }


    @Test
    public void thePlayerWithAdvantageLostsTheBall(){

    }

    @Test
    public void theGameIsInDeuceAfterPlayerWithAdvantageLostsTheBall(){

    }



}
