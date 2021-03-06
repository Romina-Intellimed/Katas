/**
 * Created by romina on 09.0size.2016.
 */
class GenerationGridBuilder {

    def size
    def positions = []

    static GenerationGridBuilder aGenerationGridBuilder() {
        new GenerationGridBuilder(size: 2)
    }

    def withSize(size) {
        this.size = size
        this
    }

    def withAliveCell(xPos, yPos) {
        positions.add([xPos, yPos])
        this
    }

    def build() {
        def grid = []

        size.times { rowIndex ->
            grid[rowIndex] = []
            size.times { colIndex ->
                grid[rowIndex][colIndex] = CellType.dead
            }
        }

       // grid= [[CellType.dead] * size] * size

        positions.eachWithIndex{ position , index ->
            grid[position[0]][position[1]] = CellType.alive
        }

       return grid
    }
}
