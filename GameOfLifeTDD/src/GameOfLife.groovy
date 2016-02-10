/**
 * Created by romina on 09.02.2016.
 */
class GameOfLife {
    def newGrid = []

    def generationGridEvolution(grid) {
        nextGenerationGridWithDifferentTypeCells(grid)
    }

    def nextGenerationGridWithDifferentTypeCells(grid) {
        (grid.size()).times { x ->
            newGrid[x] = []
            (grid.size()).times { y ->
                def aliveNeighbours = NextGenerationGridBuilder.countAliveCellNeighbours(grid, x + 1, y + 1)
                if (grid[x][y] == CellType.alive) {
                    updateNextGenerationStateForAliveCell(aliveNeighbours, x, y)
                } else {
                    updateNextGenerationStateForDeadCell(aliveNeighbours, x, y)
                }
            }
        }
        newGrid
    }


    def updateNextGenerationStateForAliveCell(aliveNeighbours, x, y) {
        if (aliveNeighbours < 2 || aliveNeighbours > 3)
            newGrid[x][y] = CellType.dead
        if (aliveNeighbours == 2 || aliveNeighbours == 3)
            newGrid[x][y] = CellType.alive
    }

    def updateNextGenerationStateForDeadCell(aliveNeighbours, x, y) {
        if (aliveNeighbours == 3) {
            newGrid[x][y] = CellType.alive
        } else
            newGrid[x][y] = CellType.dead
    }
}



