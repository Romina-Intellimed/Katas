import org.junit.Before
import org.junit.Test

/**
 * Created by romina on 03.02.2016.
 */
class GameOfLifeTest {
    def gridOfCells

    @Before
    void setup(){

        gridOfCells=new GridOfCells()

    }


    @Test
    void "this generation grid of cells exists and it is bidimensional"(){
        assert gridOfCells.bidimensionalGrid instanceof java.util.ArrayList
    }


}
