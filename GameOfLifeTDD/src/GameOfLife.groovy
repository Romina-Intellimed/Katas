/**
 * Created by romina on 09.02.2016.
 */
class GameOfLife {


    def generationGridEvolution(grid) {
        if (countLiveCells(grid) >= 3 && grid.size==2)
            nextGenerationGridWithTheSameTypeCells(grid, CellType.alive)
        else if(grid.size==2)
            nextGenerationGridWithTheSameTypeCells(grid,CellType.dead)
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

    def nextGenerationGridWithTheSameTypeCells(grid, cellType) {
        (grid.size()).times { x ->
            (grid.size()).times { y ->
                grid[x][y] = cellType
            }
        }
        grid
    }



}
