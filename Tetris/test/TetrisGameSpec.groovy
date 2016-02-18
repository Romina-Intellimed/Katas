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

    void "board 1x1 has empty squares"() {
        given:
        def aBoard=Board.aBoard()

        when:
        def oneSquareBoard = aBoard.generateEmptyBoard()

        then:
        oneSquareBoard == [0]

    }

    void "block is droped in one squared board"() {

        when:
        def board = tetrisBoard.dropBlock()

        then:
        assert board == [1]
    }


    void "line collaps for board 1x1"() {
        given:
        tetrisBoard.board = [1]
        when:
        def newBoard = tetrisBoard.lineCollaps()

        then:
        assert newBoard == 0
    }

    void "game ends for board 1x1"(){
        when:
        tetrisBoard.dropBlock()
        then:
        assert tetrisBoard.hasStackUpToTop() == true
    }


}
