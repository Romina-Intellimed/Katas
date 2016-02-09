/**
 * Created by romina on 09.02.2016.
 */
class GenerationGridBuilder {

    def size

    static GenerationGridBuilder aGenerationGridBuilder() {
        new GenerationGridBuilder(size: 2)
    }

    def build(cellType) {
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
        aGenerationGridBuilder().build(CellType.dead)
    }

    static def grid2x2WithAllCellsAlive(){
        aGenerationGridBuilder().build(CellType.alive)
    }
}
