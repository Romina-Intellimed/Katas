import spock.lang.Specification

/**
 * Created by romina on 17.02.2016.
 */
class BoardSpec extends Specification {

    Board gameBoard;

    void setup(){
        gameBoard= new Board()

    }

    void "board has only empty squares"(){

        given:
        def size = 3

        when:
        def newBoard = gameBoard.generateEmptyBoard(size)

        then:
        assert newBoard == [[SquareState.EMPTY]*3]*3
    }

    def "Board has no falling block"() {
        given:
        gameBoard.board=gameBoard.generateEmptyBoard(3)
        expect:
        gameBoard.hasFallingBlocks() == false

    }


    def "Board has one falling block"() {
        given:
        TetrisBlock tetrisBlock = new TetrisBlock()
        gameBoard.board=gameBoard.generateEmptyBoard(3)
        when:
        gameBoard.dropBlock(tetrisBlock)

        then:
        gameBoard.hasFallingBlocks() == true

    }

}
