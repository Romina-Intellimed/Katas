/**
 * Created by romina on 10.02.2016.
 */
class GridBuilder {

    CellManager cellManager = new CellManager();

    def nextGenerationGrid(grid) {

        def newGrid = []
        (grid.size()).times { x ->
            newGrid[x] = []
            (grid.size()).times { y ->
                def aliveNeighbours = countAliveCellNeighbours(grid, x, y)
                newGrid[x][y] = cellManager.updateCellState(aliveNeighbours, grid[x][y])
            }
        }
        return newGrid
    }

    private def countAliveCellNeighbours(grid, xPos, yPos) {
        def neighbours = [[xPos - 1, yPos - 1], [xPos - 1, yPos], [xPos - 1, yPos + 1], [xPos, yPos - 1], [xPos, yPos + 1], [xPos + 1, yPos - 1], [xPos + 1, yPos], [xPos + 1, yPos + 1]]

        return neighbours.inject(0) { aliveNeighbours, neighbourPosition ->
            hasNeighbour(grid, neighbourPosition) ? aliveNeighbours + 1 : aliveNeighbours
        }
    }

    private boolean hasNeighbour(grid, neighbourPosition) {
        def xPosition = neighbourPosition[0]
        def yPosition = neighbourPosition[1]
        
        return isPositionValid(xPosition, grid) &&
                isPositionValid(yPosition, grid) &&
                grid[xPosition][yPosition] == CellType.alive
    }

    private boolean isPositionValid(position, grid) {
        return position in (0..grid.size() - 1)
    }
}
