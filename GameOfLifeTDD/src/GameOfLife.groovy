/**
 * Created by romina on 09.02.2016.
 */
class GameOfLife {


    def generationGridEvolution(grid) {
        if (countLiveCells(grid) >= 3)
            GenerationGridBuilder.grid2x2WithAllCellsAlive()
        else
            GenerationGridBuilder.grid2x2WithAllCellsDead()
    }

    private int countLiveCells(grid) {
        def liveCells = 0

        (grid.size()).times { x ->
            (grid.size()).times { y ->
                if (grid[x][y] == CellType.alive)
                    liveCells++
            }
        }
        liveCells
    }
}
