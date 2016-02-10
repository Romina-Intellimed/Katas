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
                /*  if (grid[x][y] == CellType.alive) {
                      newGrid[x][y] = updateAliveCellState(aliveNeighbours)
                  } else {
                     newGrid[x][y]=updateDeadCellState(aliveNeighbours)
                  }*/
            }
        }
        newGrid
    }


    def static updateAliveCellState(aliveNeigbours) {
        if (aliveNeigbours < 2 || aliveNeigbours > 3)
            return CellType.dead
        if (aliveNeigbours == 2 || aliveNeigbours == 3)
            return CellType.alive
    }

    def static updateDeadCellState(aliveNeighbours) {
        if (aliveNeighbours == 3)
            return CellType.alive
        else
            return CellType.dead
    }

    def static updateCellState(aliveNeighbours, cellType) {
        if ((aliveNeighbours < 2 || aliveNeighbours > 3) && cellType == CellType.alive)
            return CellType.dead
        if ((aliveNeighbours == 2 || aliveNeighbours == 3) && cellType == CellType.alive)
            return CellType.alive
        if (aliveNeighbours == 3 && cellType == CellType.dead)
            return CellType.alive
        else
            return CellType.dead

    }


}



