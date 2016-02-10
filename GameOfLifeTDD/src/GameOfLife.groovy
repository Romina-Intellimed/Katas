/**
 * Created by romina on 09.02.2016.
 */
class GameOfLife {


    def generationGridEvolution(grid) {
        if (countLiveCells(grid) >= 3 && grid.size == 2)
            Grid.nextGenerationGridWithTheSameTypeCells(grid, CellType.alive)
        else if (grid.size >= 2 && countLiveCells(grid) <= 2)
            Grid.nextGenerationGridWithTheSameTypeCells(grid, CellType.dead)
        else if (grid.size >= 2 && countLiveCells(grid) > 2) {
            nextGenerationGridWithDifferentTypeCells(grid)
        }

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


    def static nextGenerationGridWithDifferentTypeCells(grid) {
        def newGrid = []
        (grid.size()).times { x ->
            newGrid[x] = []
            (grid.size()).times { y ->
                def aliveNeighbours = Grid.countAliveCellNeighbours(grid, x + 1, y + 1)
                if (grid[x][y] == CellType.alive) {
                    if (aliveNeighbours < 2)
                        newGrid[x][y] = CellType.dead
                    if (aliveNeighbours == 2 || aliveNeighbours == 3)
                        newGrid[x][y] = CellType.alive
                    if (aliveNeighbours > 3)
                        newGrid[x][y] = CellType.dead
                }
                else{
                    if(aliveNeighbours==3){
                        newGrid[x][y]=CellType.alive
                    }
                    else
                        newGrid[x][y]=CellType.dead
                }
            }
        }
        newGrid
    }


}



