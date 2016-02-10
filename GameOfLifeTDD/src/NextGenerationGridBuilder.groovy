/**
 * Created by romina on 10.02.2016.
 */
class NextGenerationGridBuilder {


    def static newGrid = []

    def static surroundGridwithDeadCells(grid) {
        def gridToCheck = []
        (grid.size()+2).times { x ->
            gridToCheck[x]=[]
            (grid.size()+2).times { y ->
                gridToCheck[x][y] = CellType.dead
            }
        }

        (gridToCheck.size()-2).times{ x->
            (gridToCheck.size()-2).times { y ->
                gridToCheck[x+1][y+1] = grid[x][y]
            }
        }
        gridToCheck
    }


    def static nextGenerationGridWithDifferentTypeCells(grid) {
        (grid.size()).times { x ->
            newGrid[x] = []
            (grid.size()).times { y ->
                def aliveNeighbours = CellManager.countAliveCellNeighbours(grid, x + 1, y + 1)
                if (grid[x][y] == CellType.alive) {
                    CellManager.updateNextGenerationStateForAliveCell(aliveNeighbours, x, y)
                } else {
                    CellManager.updateNextGenerationStateForDeadCell(aliveNeighbours, x, y)
                }
            }
        }
        newGrid
    }


}
