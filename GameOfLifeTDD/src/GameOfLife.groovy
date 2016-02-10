/**
 * Created by romina on 09.02.2016.
 */
class GameOfLife {


    def generationGridEvolution(grid) {
        nextGenerationGridWithDifferentTypeCells(grid)
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
                } else {
                    if (aliveNeighbours == 3) {
                        newGrid[x][y] = CellType.alive
                    } else
                        newGrid[x][y] = CellType.dead
                }
            }
        }
        newGrid
    }


}



