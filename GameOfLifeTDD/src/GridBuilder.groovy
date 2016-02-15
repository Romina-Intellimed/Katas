/**
 * Created by romina on 10.02.2016.
 */
class GridBuilder {

    CellManager cellManager=new CellManager();

    def nextGenerationGrid(grid) {

        def newGrid = []
        (grid.size()).times { x ->
            newGrid[x] = []
            (grid.size()).times { y ->
                def aliveNeighbours = countAliveCellNeighbours(grid, x + 1, y + 1)
                newGrid[x][y] = cellManager.updateCellState(aliveNeighbours, grid[x][y])
            }
        }
        return newGrid
    }

    private def countAliveCellNeighbours(grid, xPos, yPos) {
        def aliveNeighbours=0
        def neighbours = [[xPos - 1, yPos - 1], [xPos - 1, yPos], [xPos - 1, yPos + 1], [xPos, yPos - 1], [xPos, yPos + 1], [xPos + 1, yPos - 1], [xPos + 1, yPos], [xPos + 1, yPos + 1]]
        def surroundedGrid = surroundGridwithDeadCells(grid)

        neighbours.size().times { it->
            if(surroundedGrid[neighbours[it][0]][neighbours[it][1]]==CellType.alive)
                aliveNeighbours++

        }
        aliveNeighbours
    }

    private def surroundGridwithDeadCells(grid) {
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

}
