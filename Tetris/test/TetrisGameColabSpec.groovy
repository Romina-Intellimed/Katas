import spock.lang.Specification

/**
 * Created by romina on 25.02.2016.
 */
class TetrisGameColabSpec extends Specification{

    def tetrisGame

    void setup(){
        tetrisGame=new TetrisGame()
    }

    void "test add block is called once when board is mocked "(){

        given:
        def board=Mock(TetrisBoard)
        tetrisGame.tetrisBoard=board

        when:
        tetrisGame.dropBlock()
        then:
        1*board.addBlock(*_)
    }




}
