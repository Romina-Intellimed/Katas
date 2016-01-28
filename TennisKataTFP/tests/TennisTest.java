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
    public void onePlayerPassTheBall(){

        assertEquals("player1",testGame.chooseWhoPassTheBall("player1"));

    }

    @Test
    public void thePlayerWinsTheBall(){

        assertEquals(testGame.players.get(0).getName(),testGame.setBallWinner(testGame.players.get(0)));
    }



    @Test
    public void thePlayerWinsPoints(){


        assertEquals(testGame.players.get(0).hasScored(),testGame.players.get(0).score);

    }

    @Test
    public void thePlayerWinsPointsWhenPlayerWinsTheBall(){
        Integer winnerScore=testGame.players.get(0).getScore()+1;
        testGame.setBallWinner(testGame.players.get(0));


        assertEquals((winnerScore),testGame.players.get(0).getScore());

    }




    @Test
    public void theGameIsInEndStateAndOnePlayerHasTheMaximumScoreGreaterThanTheOpposite(){


    }





    @Test
    public void theGameIsInDeuceState(){


    }

    @Test
    public void thePlayerHasAdvantage(){


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
