import spock.lang.Ignore
import spock.lang.Specification

/**
 * Created by romina on 24.02.2016.
 */
class TetrisBoardSpec extends Specification {

    def tetrisBoard

    void setup(){
        tetrisBoard=new TetrisBoard()
    }


    void "test add block to a 1x1 board"(){
        given:
        tetrisBoard.initTheBoard(1,0)
        when:
        tetrisBoard.addBlock(0,0)
        then:
        assert tetrisBoard.board[0][0]==1
    }


    void "test delete block from a 1x1 board"(){
        given:
        tetrisBoard.initTheBoard(1,0)
        when:
        tetrisBoard.addBlock(0,0)
        then:
        assert tetrisBoard.board[0][0]==1

        when:
        tetrisBoard.removeBlock(0,0)
        then:
        assert tetrisBoard.board[0][0]==0
    }

    void "test get clok from a 1x1 board"(){
        given:
        tetrisBoard.initTheBoard(1,0)
        when:
        tetrisBoard.addBlock(0,0)
        def block = tetrisBoard.getBlock(0,0)
        then:
        assert block==1

    }


    void "test add block to a 2x2 board"(){
        given:
        tetrisBoard.initTheBoard(2,2)
        when:
        tetrisBoard.addBlock(0,0)
        then:
        assert tetrisBoard.board[0][0]==1
    }


    void "test delete block from a 2x2 board"(){
        given:
        tetrisBoard.initTheBoard(2,2)
        when:
        tetrisBoard.addBlock(0,1)
        then:
        assert tetrisBoard.board[0][1]==1

        when:
        tetrisBoard.removeBlock(0,1)
        then:
        assert tetrisBoard.board[0][1]==0
    }


    void "test get clok from a 2x2 board"(){
        given:
        tetrisBoard.initTheBoard(2,2)
        when:
        tetrisBoard.addBlock(1,1)
        def block = tetrisBoard.getBlock(1,1)
        then:
        assert block==1

    }




}
