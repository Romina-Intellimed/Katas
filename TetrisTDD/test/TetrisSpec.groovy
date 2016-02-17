import spock.lang.Specification

/**
 * Created by romina on 12.02.2016.
 */
class TetrisSpec extends Specification {
    Board gameBoard;

    void setup() {
        gameBoard = new Board()
        gameBoard.board = gameBoard.generateEmptyBoard(3)
    }

    def "Block falls one time a line "() {
        given:
        TetrisBlock tetrisBlock = new TetrisBlock()

        when:
        gameBoard.board = gameBoard.dropBlock(tetrisBlock)
        gameBoard.board = gameBoard.blockIsFallingOneTimeALine()

        then:
        println(gameBoard.board)
        gameBoard.hasFallingBlocks() == true
    }


    def "Block has arrived at the bottom"() {
        given:
        TetrisBlock tetrisBlock = new TetrisBlock()
        when:
        gameBoard.dropBlock(tetrisBlock)
        gameBoard.blockIsFallingOneTimeALine()
        gameBoard.blockIsFallingOneTimeALine()

        then:
        println(gameBoard.board)

        assert gameBoard.blockHasArrivedAtBottom() == true
    }


    def "Block hits another block"() {
        given:
        TetrisBlock tetrisBlock = new TetrisBlock()
        gameBoard.board = [[0, 0, 0], [0, 0, 0], [0, 1, 0]]

        when:
        gameBoard.dropBlock(tetrisBlock)
        gameBoard.blockIsFallingOneTimeALine()

        then:
        gameBoard.blockHasReachedAnotherBlock() == true
    }


    def "Block moves right"() {
        given:
        TetrisBlock tetrisBlock = new TetrisBlock()

        when:
        gameBoard.dropBlock(tetrisBlock)
        gameBoard.blockIsFallingOneTimeALine()
        gameBoard.blockMovesRight()
        then:
        assert gameBoard.board == [[0, 0, 0], [0, 0, 1], [0, 0, 0]]
    }


    def "Block moves left"() {
        given:
        TetrisBlock tetrisBlock = new TetrisBlock()

        when:
        gameBoard.dropBlock(tetrisBlock)
        gameBoard.blockIsFallingOneTimeALine()
        gameBoard.blockMovesLeft()
        then:
        assert gameBoard.board == [[0, 0, 0], [1, 0, 0], [0, 0, 0]]
    }


    def "Block is falling bottom right corner"() {
        given:
        TetrisBlock tetrisBlock = new TetrisBlock()

        when:
        gameBoard.dropBlock(tetrisBlock)
        gameBoard.blockIsFallingOneTimeALine()
        gameBoard.blockMovesRight()
        gameBoard.blockIsFallingOneTimeALine()
        then:
        assert gameBoard.board == [[0, 0, 0], [0, 0, 0], [0, 0, 1]]
    }

    def "Block is falling bottom left corner"() {
        given:
        TetrisBlock tetrisBlock = new TetrisBlock()

        when:
        gameBoard.dropBlock(tetrisBlock)
        gameBoard.blockIsFallingOneTimeALine()
        gameBoard.blockMovesLeft()
        gameBoard.blockIsFallingOneTimeALine()
        then:
        assert gameBoard.board == [[0, 0, 0], [0, 0, 0], [1, 0, 0]]
    }


    def "One line of blocks is formed"() {
        given:
        TetrisBlock tetrisBlock = new TetrisBlock()

        when:
        gameBoard.dropBlock(tetrisBlock)
        gameBoard.blockIsFallingOneTimeALine()
        gameBoard.blockMovesLeft()
        gameBoard.blockIsFallingOneTimeALine()

        gameBoard.dropBlock(tetrisBlock)
        gameBoard.blockIsFallingOneTimeALine()
        gameBoard.blockMovesRight()
        gameBoard.blockIsFallingOneTimeALine()

        gameBoard.dropBlock(tetrisBlock)
        gameBoard.blockIsFallingOneTimeALine()
        //gameBoard.blockMovesLeft()
        gameBoard.blockIsFallingOneTimeALine()


        then:
        assert gameBoard.board == [[0, 0, 0], [0, 0, 0], [1, 1, 1]]
    }


    def "One line of blocks collapses"() {
        given:
        TetrisBlock tetrisBlock = new TetrisBlock()

        when:
        gameBoard.dropBlock(tetrisBlock)
        gameBoard.blockIsFallingOneTimeALine()
        gameBoard.blockMovesLeft()
        gameBoard.blockIsFallingOneTimeALine()

        gameBoard.dropBlock(tetrisBlock)
        gameBoard.blockIsFallingOneTimeALine()
        gameBoard.blockMovesRight()
        gameBoard.blockIsFallingOneTimeALine()

        gameBoard.dropBlock(tetrisBlock)
        gameBoard.blockIsFallingOneTimeALine()
        gameBoard.blockIsFallingOneTimeALine()

        gameBoard.lineCollaps()

        then:
        assert gameBoard.board == [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
    }


    def "Block is put on top of the bottom existant block"() {
        given:
        TetrisBlock tetrisBlock = new TetrisBlock()

        when:
        gameBoard.dropBlock(tetrisBlock)
        gameBoard.blockIsFallingOneTimeALine()
        gameBoard.blockMovesLeft()
        gameBoard.blockIsFallingOneTimeALine()

        gameBoard.dropBlock(tetrisBlock)
        gameBoard.blockIsFallingOneTimeALine()
        gameBoard.blockMovesLeft()
        gameBoard.blockIsFallingOneTimeALine()

        gameBoard.dropBlock(tetrisBlock)
        gameBoard.blockIsFallingOneTimeALine()
        gameBoard.blockIsFallingOneTimeALine()

        gameBoard.lineCollaps()

        then:
        assert gameBoard.board == [[0, 0, 0], [1, 0, 0], [1, 1, 0]]
    }


}
