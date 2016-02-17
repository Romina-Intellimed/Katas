import spock.lang.Specification

/**
 * Created by romina on 17.02.2016.
 */
class TetrisGameSpec extends Specification{

    Board tetrisBoard;

    void setup(){
       tetrisBoard=new Board()

    }

    void "empty board"(){

        expect:
        tetrisBoard.isEmpty()

    }

    void "board 1x1 has empty squares"(){
        when:
        def oneSquareBoard=tetrisBoard.generateEmptyBoard(1)

        then:
        oneSquareBoard == [[0]]

    }

}
