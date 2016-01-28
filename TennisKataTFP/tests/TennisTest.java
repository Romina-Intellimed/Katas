import com.sun.media.jfxmedia.events.PlayerStateEvent;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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

        assertTrue(testGame.playersList.size()==2);

    }

    @Test
    public void theGameisInStartState(){

        assertTrue(testGame.state=="START");
    }



    @Test
    public void onePlayerShouldServe(){




    }



}
