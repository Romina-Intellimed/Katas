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
        def aBoard = BoardBuilder.aBoard().withSize(1,0).buildBoard()
        tetrisBoard.board = aBoard
        when:
        def oneSquareBoard = tetrisBoard.initTheBoard(1,0)
        then:
        oneSquareBoard == aBoard
    }

    void "block is droped in one squared board"() {
        given:
        def aBoard = BoardBuilder.aBoard().withSize(1,0).buildBoard()
        tetrisBoard.board = aBoard

        when:
        def board = tetrisBoard.dropBlock()

        then:
        assert board[0] == 1
    }


    void "line collaps for board 1x1 squared filled"() {
        when:
        tetrisBoard.dropBlock()
        def newBoard = tetrisBoard.lineCollaps()
        then:
        assert newBoard[0] == 0
    }

    void "game ends for board 1x1"() {
        given:
        def aBoard = BoardBuilder.aBoard().withSize(1,0).buildBoard()
        tetrisBoard.board = aBoard
        when:
        tetrisBoard.dropBlock()
        then:
        assert tetrisBoard.hasStackUpToTop() == true
    }



    void "a board 2x2 has empty squares"() {
        given:
        def aBoard = BoardBuilder.aBoard().withSize(2,2).buildBoard()
        tetrisBoard.board = aBoard
        when:
        def oneSquareBoard = tetrisBoard.initTheBoard(2,2)

        then:
        oneSquareBoard == aBoard
        print oneSquareBoard
    }

    @Ignore
    void "a block is droped in a 2x2 board "() {
        given:
        def aBoard = BoardBuilder.aBoard().withSize(2,2).buildBoard()
        tetrisBoard.board = aBoard

        when:
        tetrisBoard.dropBlock()

        then:
        assert aBoard==1

    }

    void "a board 2x2 has one falling block"() {

    }

    void "blocked has arrived at the bottom right corner in a 2x2 board"() {

    }

    void "block has arrived at the bootom left corner in a 2x2 board "(){

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

    void "in a 3x3 board there is one falling block"(){

    }

    void "in a 3x3 board a block falls starting at the middle top of the board"(){

    }

    void "in a 3x3 board block falls one time a line in a 3x3 board"(){

    }

    void "in a 3x3 board blocks moves at the right"(){

    }


    void "in a 3x3 board blocks moves at the left"(){

    }

    void "in a 3x3 board block hits another block"(){


    }


    void "in a 3x3 board a block arrives at the bottom"(){

    }

    void "in a 3x3 block a bottom line collapses"(){

    }

    void "in a 3x3 block a line collapses"(){

    }
    void "in a 3x3 block games arrives to end"(){

    }
}
