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

    def static countAliveCellNeighbours(grid, xPos, yPos) {
        def aliveNeighbours=0
        def neighbours = [[xPos - 1, yPos - 1], [xPos - 1, yPos], [xPos - 1, yPos + 1], [xPos, yPos - 1], [xPos, yPos + 1], [xPos + 1, yPos - 1], [xPos + 1, yPos], [xPos + 1, yPos + 1]]
        def surroundedGrid = NextGenerationGridBuilder.surroundGridwithDeadCells(grid)

        neighbours.size().times { it->
            if(surroundedGrid[neighbours[it][0]][neighbours[it][1]]==CellType.alive)
                aliveNeighbours++

        }
        aliveNeighbours
    }

    def static nextGenerationGridWithDifferentTypeCells(grid) {
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

    def static updateNextGenerationStateForAliveCell(aliveNeighbours, x, y) {
        if (aliveNeighbours < 2 || aliveNeighbours > 3)
            newGrid[x][y] = CellType.dead
        if (aliveNeighbours == 2 || aliveNeighbours == 3)
            newGrid[x][y] = CellType.alive
    }

    def static updateNextGenerationStateForDeadCell(aliveNeighbours, x, y) {
        if (aliveNeighbours == 3) {
            newGrid[x][y] = CellType.alive
        } else
            newGrid[x][y] = CellType.dead
    }
}
