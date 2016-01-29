import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by romina on 28.01.2016.
 */
public class PlayerTest {



    Player testPlayer;

    @Before
    public void setup(){
        testPlayer=new Player("custom");

    }


    @Test
    public void thePlayerWinsPoints(){

        //todo: test player.hasScoreMethod

        Integer expectedPoints=testPlayer.getScore()+1;

        Integer actualPoints=testPlayer.hasScored();

        assertEquals("The new score: " +actualPoints +" schould be greater with one point more than "+expectedPoints,expectedPoints,actualPoints);

    }
}
