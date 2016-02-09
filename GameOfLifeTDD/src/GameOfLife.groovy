/**
 * Created by romina on 09.02.2016.
 */
class GameOfLife {


    def generationGridEvolution(grid) {
        if (countLiveCells(grid) >= 3)
            [[CellType.alive, CellType.alive], [CellType.alive, CellType.alive]]
        else
            [[CellType.dead, CellType.dead], [CellType.dead, CellType.dead]]
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
