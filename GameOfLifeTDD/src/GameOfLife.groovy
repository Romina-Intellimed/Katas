/**
 * Created by romina on 09.02.2016.
 */
class GameOfLife {

    GridBuilder gridBuilder;

    GameOfLife(){
        gridBuilder=new GridBuilder()
    }
    def generationGridEvolution(grid) {

        gridBuilder.nextGenerationGridWithDifferentTypeCells(grid)
    }


}



