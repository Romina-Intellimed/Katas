import spock.lang.Specification

/**
 * Created by romina on 25.02.2016.
 */
class TetrisGameColabSpec extends Specification {

    def tetrisGame

    void setup() {
        tetrisGame = new TetrisGame()
    }

    void "test addblock is called once when board is mocked "() {

        given:
        def boardMock = Mock(TetrisBoard)
        tetrisGame.tetrisBoard = boardMock

        when:
        tetrisGame.dropBlock()
        then:
        1 * boardMock.addBlock(*_)
    }






    void "test tetrisGame in isolation"() {
        given:
        def boardStub = Mock(TetrisBoard)
        def expectedBoard = BoardBuilder.aBoard().withSize(2, 2).buildBoard()
        boardStub.initTheBoard(*_) >> expectedBoard
        def tetrisGame = new TetrisGame(tetrisBoard: boardStub)
        when:
        def board= tetrisGame.tetrisBoard.initTheBoard(2,2)
        then:
        assert board == expectedBoard
    }




}
