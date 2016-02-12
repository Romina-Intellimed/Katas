import spock.lang.Ignore
import spock.lang.Specification

/**
 * Created by romina on 12.02.2016.
 */
class FallingBlockTest extends Specification {
    Board gameBoard;

    void setup(){
        gameBoard=new Board()
    }


    void "Board with no falling piece is empty"(){
        expect:
        gameBoard.isEmpty() == true

    }

    void "Board has no falling blocks"(){
        expect:
        !(gameBoard.hasFallingBlocks()) == false
    }




}
