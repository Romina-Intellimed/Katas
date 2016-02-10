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
                newGrid[x][y] = updateCellState(aliveNeighbours, grid[x][y])
            }
        }
        newGrid
    }



    def static updateCellState(aliveNeighbours, cell) {
        if ((aliveNeighbours < 2 || aliveNeighbours > 3) && isAlive(cell))
            return CellType.dead
        if ((aliveNeighbours == 2 || aliveNeighbours == 3) && isAlive(cell))
            return CellType.alive
        if (aliveNeighbours == 3 && !isAlive(cell))
            return CellType.alive
        else
            return CellType.dead

    }

    private static boolean isAlive(cellType) {
        cellType == CellType.alive
    }


}



