import spock.lang.Ignore
import spock.lang.Specification

/**
 * Created by romina on 12.02.2016.
 */
class FallingBlockTetrisTest extends Specification {
    Board gameBoard;

    void setup(){
        gameBoard=new Board()
    }


    def "Board with no falling piece is empty"(){
        expect:
        gameBoard.isEmpty() == true

    }

    def "Board has no falling block"(){
      expect:
        gameBoard.hasFallingBlocks() == false

    }


    def "Board has one falling block"(){

        when:
        gameBoard.dropBlock()

        then:
        gameBoard.hasFallingBlocks() == true

    }

    def "Block falls one time a line "(){
        when:
        gameBoard.dropBlock()
        gameBoard.blockIsFalling()

        then:
        gameBoard.hasFallingBlocks() == true
    }




}
