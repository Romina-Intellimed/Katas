import spock.lang.Specification

/**
 * Created by romina on 17.02.2016.
 */
class BoardSpec extends Specification {

    Board gameBoard;

    void setup(){
        gameBoard= new Board()

    }


    def "Board with no falling piece is empty"() {

        given:
        def size = 3

        when:
        gameBoard.board = gameBoard.generateEmptyBoard(size)

        then:
        gameBoard.isEmpty() == true

    }

    void "Board 3x3 has only empty squares"(){

        given:
        def size = 3

        when:
        def newBoard = gameBoard.generateEmptyBoard(size)

        then:
        assert newBoard == [[BoardSquare.EMPTY]*3]*3
    }

    def "Board 3x3 has no falling block"() {
        given:
        gameBoard.board=gameBoard.generateEmptyBoard(3)
        expect:
        gameBoard.hasFallingBlocks() == false

    }


    def "Board 3x3 has one falling block"() {
        given:
        TetrisBlock tetrisBlock = new TetrisBlock()
        gameBoard.board=gameBoard.generateEmptyBoard(3)
        when:
        gameBoard.dropBlock(tetrisBlock)

        then:
        gameBoard.hasFallingBlocks() == true

    }



}
