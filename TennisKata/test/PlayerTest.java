import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Romina DRUTA on 25.01.2016.
 */
public class PlayerTest {

    private Player playerTest;

    @Before
    public void setup() {
        playerTest = new Player("Test");
        playerTest.score=20;
    }

    @Test
    public void dummyTest() {
        assert true;
    }



    @Test
    public void addPointsShouldIncreaseByOne(){
        Integer scoreInput=this.playerTest.score;

        Integer expectedScoreOutput=21;

        Integer actualScoreOutput=playerTest.addPoints();



        assertEquals("for input " +scoreInput + " result score should be " + actualScoreOutput, expectedScoreOutput, actualScoreOutput);




    }




}
