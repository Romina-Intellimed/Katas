/**
 * Created by romina on 09.02.2016.
 */
class GenerationGridBuilder {

    def size

    static GenerationGridBuilder aGenerationGridBuilder() {
        new GenerationGridBuilder(size: 2)
    }

    def build() {
        def grid = []
        2.times { rowIndex ->
            grid[rowIndex] = []
            2.times { colIndex ->
                grid[rowIndex][colIndex] = CellType.dead
            }
        }
        grid
    }

    static def theDefault() {
        aGenerationGridBuilder().build()
    }
}
