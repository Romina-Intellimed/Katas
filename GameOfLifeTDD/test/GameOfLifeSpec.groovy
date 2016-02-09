import spock.lang.Specification

/**
 * Created by romina on 09.02.2016.
 */
class GameOfLifeSpec extends Specification {

    GameOfLife gameOfLife
    void setup() {
        gameOfLife=new GameOfLife()
    }

    void "a 2x2 grid with no live cells will have no live cell in next generation"(){
        given:
        def actualGrid=[[0,0],[0,0]]
        when:
        def expectedGrid= gameOfLife.generationGridEvolution(actualGrid)
        then:
        expectedGrid == [[0,0],[0,0]]
    }


    void "a 2x2 grid with one live cells will have no live cell in next generation"(){

    }


    void "a 2x2 grid with two live cells will have no live cell in next generation"(){

    }


    void "a 2x2 grid with three live cells will have four live cells in next generation"(){

    }


    void "a 2x2 grid with four live cells will have no live cells in next generation"(){

    }


    void "a 3x3 grid with one live cells will have no live cell in next generation"(){

    }



    void "a 3x3 grid with two live cells will have no live cell in next generation"(){

    }



    void "a 3x3 grid with three live cells on the position: (0,0),(0,1),(0,2) will have one live cell in next generation"(){

    }

    void "a 3x3 grid with three live cells on the position: (0,0),(0,1),(1,0) will have four live cells in next generation"(){

    }

    void "a 3x3 grid with three live cells on the position: (0,0),(0,1),(1,1) will have six live cells in next generation"(){

    }




}
