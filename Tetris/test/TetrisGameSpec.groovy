import spock.lang.Ignore
import spock.lang.Specification

class TetrisGameSpec extends Specification {

    TetrisGame tetrisGame;

    void setup() {
        tetrisGame = new TetrisGame()
    }

    void "empty board"() {
        expect:
        tetrisGame.tetrisBoard.isEmpty()

    }

    void "board 1x1 has empty squares after init"() {
        given:
        def aBoard = BoardBuilder.aBoard().withSize(1,0).buildBoard()
        tetrisGame.board = aBoard
        when:
        def oneSquareBoard = tetrisGame.tetrisBoard.initTheBoard(1,0)
        then:
        oneSquareBoard == aBoard
    }

    void "block is droped in 1x1 board"() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(1,0)
        when:
        tetrisGame.dropBlock()

        then:
        assert tetrisGame.tetrisBoard.getBlock(0,1) == 1
    }

    void "game ends for board 1x1"() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(1,0)
        when:
        tetrisGame.dropBlock()
        then:
        assert tetrisGame.hasStackUpToTop() == true
    }



    void "a board 2x2 has empty squares after init"() {
        given:
        def aBoard = BoardBuilder.aBoard().withSize(2,2).buildBoard()
        tetrisGame.board = aBoard
        when:
        def oneSquareBoard = tetrisGame.tetrisBoard.initTheBoard(2,2)

        then:
        oneSquareBoard == aBoard
        print oneSquareBoard
    }

    void "a block is droped in a 2x2 board "() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(2,2)

        when:
        tetrisGame.dropBlock()

        then:
        assert tetrisGame.tetrisBoard.getBlock(0,1)==1
    }

    void "a board 2x2 has one falling block"() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(2,2)

        when:
        tetrisGame.dropBlock()

        then:
        assert tetrisGame.hasOneFallingBlock()==true
    }


    @Ignore
    void "in a 2x2board a block is falling one time a line"(){
        given:
        tetrisGame.tetrisBoard.initTheBoard(2,2)
        when:
        tetrisGame.dropBlock()
        tetrisGame.blockFallOneTimeAline()
        then:
        assert tetrisGame.board[1][1]==1
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
