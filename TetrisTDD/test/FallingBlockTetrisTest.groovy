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
        gameBoard.isEmpty() == [[0,0,0],[0,0,0],[0,0,0]]

    }

    def "Board has no falling blocks"(){
        expect:
        !(gameBoard.hasFallingBlocks()) == false
    }

    def "Board has one falling block"(){
        given:
        def block=new BlockTetris()

        when:
        gameBoard.dropBlock(block)

        then:
        gameBoard.hasFallingBlocks() == true

    }




}
