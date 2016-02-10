/**
 * Created by romina on 09.02.2016.
 */
class CellManager {


    def static updateNextGenerationStateForAliveCell(grid, x, y) {
        def aliveNeighbours=countAliveCellNeighbours(grid, x+1, y+1)
        if (aliveNeighbours < 2 || aliveNeighbours > 3)
            NextGenerationGridBuilder.newGrid[x][y] = CellType.dead
        if (aliveNeighbours == 2 || aliveNeighbours == 3)
            NextGenerationGridBuilder.newGrid[x][y] = CellType.alive
    }

    def static updateNextGenerationStateForDeadCell(grid, x, y) {
       def aliveNeighbours=countAliveCellNeighbours(grid, x+1, y+1)
        if (aliveNeighbours == 3) {
            NextGenerationGridBuilder.newGrid[x][y] = CellType.alive
        } else
            NextGenerationGridBuilder.newGrid[x][y] = CellType.dead
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
}
