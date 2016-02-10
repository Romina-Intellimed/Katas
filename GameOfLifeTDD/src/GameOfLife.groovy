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
                newGrid[x][y] = Cell.updateCellState(aliveNeighbours, grid[x][y])
            }
        }
        newGrid
    }


}



