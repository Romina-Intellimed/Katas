/**
 * Created by romina on 09.0size.2016.
 */
class GenerationGridBuilder {

    def size
    def aliveXPositions
    def aliveYPositions
    def positions = []

    static GenerationGridBuilder aGenerationGridBuilder() {
        new GenerationGridBuilder(size: 2, aliveYPositions: [], aliveXPositions: [])
    }

    def withSize(size) {
        this.size = size
        this
    }

    def withAliveCell(xPos, yPos) {
        aliveXPositions.add(xPos)
        aliveYPositions.add(yPos)
        this
    }

    def withAliveCellArray(xPos, yPos) {
        positions.add([xPos, yPos])
        this
    }

    def build() {
        def grid = []
        size.times { rowIndex ->
            grid[rowIndex] = []
            size.times { colIndex ->
                if (rowIndex in aliveXPositions && colIndex in aliveYPositions) grid[rowIndex][colIndex] = CellType.alive
                else grid[rowIndex][colIndex] = CellType.dead
            }
        }
        grid
    }


    def buildWithArray() {
        def grid = []
        size.times { rowIndex ->
            grid[rowIndex] = []
            size.times { colIndex ->
                grid[rowIndex][colIndex] = CellType.dead
            }
        }

        positions.size().times { it ->
            grid[positions[it][0]][positions[it][1]] = CellType.alive
        }
    positions = []
        grid
    }


    def buildWithOneCellType(cellType) {
        def grid = []
        size.times { rowIndex ->
            grid[rowIndex] = []
            size.times { colIndex ->
                grid[rowIndex][colIndex] = cellType
            }
        }
        grid
    }

    static def grid2x2WithAllCellsDead() {
        aGenerationGridBuilder().buildWithOneCellType(CellType.dead)
    }

    static def grid2x2WithAllCellsAlive() {
        aGenerationGridBuilder().buildWithOneCellType(CellType.alive)
    }
}
