/**
 * Created by romina on 09.02.2016.
 */
class GenerationGridBuilder {

    def size
    def xPos
    def yPos

    static GenerationGridBuilder aGenerationGridBuilder() {
        new GenerationGridBuilder(size: 2)
    }

    def withAliveCell(xPos, yPos) {
        this.xPos = xPos
        this.yPos = yPos
        return this
    }

    def build() {
        def grid = []
        2.times { rowIndex ->
            grid[rowIndex] = []
            2.times { colIndex ->
                if (xPos == rowIndex && yPos == colIndex) grid[rowIndex][colIndex] = CellType.alive
                else grid[rowIndex][colIndex] = CellType.dead
            }
        }
        grid
    }

    def buildWithOneCellType(cellType) {
        def grid = []
        2.times { rowIndex ->
            grid[rowIndex] = []
            2.times { colIndex ->
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
