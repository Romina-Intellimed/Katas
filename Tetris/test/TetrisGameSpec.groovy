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
        def aBoard = BoardBuilder.aBoard().withSize(1, 0).buildBoard()
        tetrisGame.tetrisBoard.board = aBoard
        when:
        def oneSquareBoard = tetrisGame.tetrisBoard.initTheBoard(1, 0)
        then:
        oneSquareBoard == aBoard
    }

    void "block is droped in 1x1 board"() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(1, 0)
        when:
        tetrisGame.dropBlock()

        then:
        assert getBlockAt(0, 1) == 1
    }

    void "game ends for board 1x1"() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(1, 0)
        when:
        tetrisGame.dropBlock()
        then:
        assert tetrisGame.hasStackUpToTop() == true
    }


    void "a board 2x2 has empty squares after init"() {
        given:
        def aBoard = BoardBuilder.aBoard().withSize(2, 2).buildBoard()
        tetrisGame.tetrisBoard.board = aBoard
        when:
        def oneSquareBoard = tetrisGame.tetrisBoard.initTheBoard(2, 2)

        then:
        oneSquareBoard == aBoard
        print oneSquareBoard
    }

    void "a block is droped in a 2x2 board "() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(2, 2)

        when:
        tetrisGame.dropBlock()

        then:
        assert getBlockAt(0, 0) == 1
    }

    void "a board 2x2 has one falling block"() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(2, 2)

        when:
        tetrisGame.dropBlock()

        then:
        assert tetrisGame.hasOneFallingBlock() == true
    }


    void "in a 2x2board a block is falling one time a line"() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(2, 2)
        when:
        tetrisGame.dropBlock()
        tetrisGame.blockFallsOneTimeAline()
        then:
        assert getBlockAt(0, 0) == 0
        assert getBlockAt(1, 0) == 1
    }


    void "blocked is moved left in 2x2 board"() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(2, 2)
        when:
        tetrisGame.dropBlock()
        tetrisGame.moveBlockLeft()
        then:
        assert getBlockAt(0, 0) == 0
        assert getBlockAt(0, 1) == 1

    }

    void "blocked is moved right in a 2x2 board"() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(2, 2)
        when:
        tetrisGame.dropBlock()
        tetrisGame.moveBlockLeft()

        then:
        assert getBlockAt(0, 0) == 0
        assert getBlockAt(0, 1) == 1

        when:
        tetrisGame.moveBlockRight()

        then:
        assert getBlockAt(0, 0) == 1
        assert getBlockAt(0, 1) == 0


    }


    void "blocked has arrived at the bottom right corner in a 2x2 board"() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(2, 2)
        when:
        tetrisGame.dropBlock()
        tetrisGame.moveBlockRight()
        tetrisGame.blockFallsOneTimeAline()

        then:
        assert getBlockAt(1, 1) == 1


    }

    void "block has arrived at the bootom left corner in a 2x2 board "() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(2, 2)
        when:
        tetrisGame.dropBlock()
        tetrisGame.blockFallsOneTimeAline()

        then:
        assert getBlockAt(1, 0) == 1

    }

    def getBlockAt(row, col) {
        tetrisGame.tetrisBoard.getBlock(row, col)
    }


    void "line dissapears in a 2x2 board"() {
        given:
        def aBoard = BoardBuilder.aBoard().withSize(2, 2).withFilledSquares(1, 0).withFilledSquares(1, 1).buildBoard()
        tetrisGame.tetrisBoard.board = aBoard
        when:
        tetrisGame.bottomLineDissapears()
        then:
        assert tetrisGame.tetrisBoard.hasEmptySquares() == true
    }

    void "block has reached another block in a 2x2 board"() {
        given:
        def aBoard = BoardBuilder.aBoard().withSize(2, 2).withFilledSquares(1, 0).buildBoard()
        tetrisGame.tetrisBoard.board = aBoard
        tetrisGame.dropBlock()
        expect:
        assert tetrisGame.blockHasReachedAnotherBlock() == true
    }

    void "block has reached the bottom in a 2x2 board"() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(2, 2)
        tetrisGame.dropBlock()
        tetrisGame.blockFallsOneTimeAline()
        expect:
        tetrisGame.blockHasReachedTheBottom()
    }

    void "game over for a 2x2 board"() {
        given:
        def aBoard = BoardBuilder.aBoard().withSize(2, 2).withFilledSquares(0, 1).buildBoard()
        tetrisGame.tetrisBoard.board = aBoard
        tetrisGame.dropBlock()
        expect:
        assert tetrisGame.hasStackUpToTop() == true

    }

    void "in a 3x3 board there is one falling block"() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(3, 3)
        tetrisGame.dropBlock()
        tetrisGame.dropBlock()
        expect:
        assert tetrisGame.hasOneFallingBlock() == true
    }

    void "in a 3x3 board a block falls starting at the middle top of the board"() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(3, 3)
        when:
        tetrisGame.dropBlock()
        then:
        assert tetrisGame.tetrisBoard.board == BoardBuilder.aBoard().withSize(3, 3).withFilledSquares(0, 1).buildBoard()
    }

    void "in a 3x3 board block falls one time a line in a 3x3 board"() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(3, 3)
        tetrisGame.dropBlock()

        when:
        tetrisGame.blockFallsOneTimeAline()

        then:
        assert tetrisGame.tetrisBoard.board == BoardBuilder.aBoard().withSize(3, 3).withFilledSquares(1, 1).buildBoard()
    }

    void "in a 3x3 board block moves at the right"() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(3, 3)
        tetrisGame.dropBlock()

        when:
        tetrisGame.moveBlockRight()

        then:
        assert tetrisGame.tetrisBoard.board == BoardBuilder.aBoard().withSize(3, 3).withFilledSquares(0, 2).buildBoard()

    }


    void "in a 3x3 board block moves at the left"() {
        given:
        tetrisGame.tetrisBoard.initTheBoard(3, 3)
        tetrisGame.dropBlock()

        when:
        tetrisGame.moveBlockLeft()

        then:
        assert tetrisGame.tetrisBoard.board == BoardBuilder.aBoard().withSize(3, 3).withFilledSquares(0, 0).buildBoard()

    }

    void "in a 3x3 board block hits another block"() {
        given:
        tetrisGame.tetrisBoard.board = BoardBuilder.aBoard().withSize(3, 3).withFilledSquares(2, 1).buildBoard()
        tetrisGame.dropBlock()
        tetrisGame.blockFallsOneTimeAline()

        expect:
        assert tetrisGame.blockHasReachedAnotherBlock() == true


    }


    void "in a 3x3 board a block arrives at the bottom"() {

    }

    void "in a 3x3 block a bottom line collapses"() {

    }

    void "in a 3x3 block a line collapses"() {

    }

    void "in a 3x3 block games arrives to end"() {

    }
}
