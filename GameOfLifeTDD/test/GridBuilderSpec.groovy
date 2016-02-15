import spock.lang.Specification

/**
 * Created by romina on 12.02.2016.
 */
class GridBuilderSpec extends Specification {

    def GridBuilder gridBuilder

    def setup() {
        gridBuilder = new GridBuilder()
    }

    void "test next generation grid collaboration"() {
        given:
        def grid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 0).withAliveCell(1, 0).withAliveCell(2, 0).build()

        def cellMock = Mock(CellManager)
        def gridBuilder = new GridBuilder(cellManager: cellMock)
        when:
        gridBuilder.nextGenerationGrid(grid)
        then:
        9 * cellMock.updateCellState(*_)
    }

    void "test cell stub and grid state in isolation"() {
        given:
        def grid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 0).withAliveCell(1, 0).withAliveCell(2, 0).build()

        def cellManager = new CellManager()
        def cellType=CellType.alive

        def cellManagerStub = Mock(CellManager) {
            updateCellState(3,CellType.alive) >> cellManager
        }

        def gridBuilder = new GridBuilder(cellManager: cellManagerStub)

        when:
        def newGrid=gridBuilder.nextGenerationGrid(grid)

        then:
        newGrid == GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(1, 1).withAliveCell(1, 0).build()
    }



}
