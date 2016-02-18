import spock.lang.Ignore
import spock.lang.Specification

/**
 * Created by romina on 17.02.2016.
 */
class TetrisGameSpec extends Specification {

    Board tetrisBoard;

    void setup() {
        tetrisBoard = new Board()

    }

    void "empty board"() {
        expect:
        tetrisBoard.isEmpty()

    }

    void "board 1x1 has empty square"() {
        given:
        def aBoard = BoardBuilder.aBoard().withSize(1).buildBoard()
        tetrisBoard.board = aBoard
        when:
        def oneSquareBoard = tetrisBoard.emptyTheBoard()

        then:
        oneSquareBoard == aBoard
    }

    void "block is droped in one squared board"() {
        given:
        def aBoard = BoardBuilder.aBoard().withSize(1).buildBoard()
        tetrisBoard.board = aBoard

        when:
        def board = tetrisBoard.dropBlock()

        then:
        assert board == [1]
    }


    void "line collaps for board 1x1 squared filled"() {
        given:
        def aBoard = BoardBuilder.aBoard().withSize(1).buildBoard()
        tetrisBoard.board = aBoard

        when:
        tetrisBoard.dropBlock()
        def newBoard = tetrisBoard.lineCollaps()

        then:
        assert newBoard == 0
    }

    void "game ends for board 1x1"() {
        given:
        def aBoard = BoardBuilder.aBoard().withSize(1).buildBoard()
        tetrisBoard.board = aBoard
        when:
        tetrisBoard.dropBlock()
        then:
        assert tetrisBoard.hasStackUpToTop() == true
    }

    void "a board 2x2 has empty squares"() {
        given:
        def aBoard = BoardBuilder.aBoard().withSize(2).buildBoard()
        tetrisBoard.board = aBoard
        when:
        def oneSquareBoard = tetrisBoard.emptyTheBoard()

        then:
        oneSquareBoard == aBoard
    }

    @Ignore
    void "a block is droped in a 2x2 board "() {
        def aBoard = BoardBuilder.aBoard().withSize(2).buildBoard()
        tetrisBoard.board = aBoard

        tetrisBoard.dropBlock()


    }

    void "a board 2x2 has one falling block"() {

    }

    void "blocked has arrived at the bottom in a 2x2 board"() {

    }

    void "blocked is moved left in 2x2 board"() {

    }

    void "blocked is moved right in a 2x2 board"() {

    }

    void "line collaps in a 2x2 board"() {

    }

    void "block has arrived on top of another block in a 2x2 board"() {

    }

    void "game over for a 2x2 board"() {

    }


}
