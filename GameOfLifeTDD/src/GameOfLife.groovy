/**
 * Created by romina on 09.02.2016.
 */
class GameOfLife {

    GridBuilder gridBuilder = new GridBuilder()

    def generationGridEvolution(grid) {
        gridBuilder.nextGenerationGrid(grid)
    }


}



