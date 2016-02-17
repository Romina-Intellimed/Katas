import spock.lang.Specification

/**
 * Created by romina on 17.02.2016.
 */
class TetrisGameSpec extends Specification{

    void setup(){

    }

    void "empty board"(){
        given:
        def tetrisBoard=new Board()

        expect:
        tetrisBoard.isEmpty()

    }



}
