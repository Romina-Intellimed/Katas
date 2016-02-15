import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by romina on 12.02.2016.
 */
class GridBuilderSpec extends Specification {

    def GridBuilder gridBuilder
    def cellManagerStub
    def cellManagerMock

    def setup() {
        gridBuilder = new GridBuilder()
        cellManagerStub = Mock(CellManager)
        cellManagerMock = Mock(CellManager)
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

    void "new grid contains cells returned by updateCellState"() {
        given:
        cellManagerStub.updateCellState(*_) >> CellType.alive
        def gridBuilder = new GridBuilder(cellManager: cellManagerStub)

        when:
        def newGrid = gridBuilder.nextGenerationGrid(emptyGrid())

        then:
        newGrid == [[CellType.alive] * 3] * 3
    }

    void "counts neighbours correctly when no neighbours"() {
        given:
        def gridBuilder = new GridBuilder(cellManager: cellManagerMock)

        when:
        gridBuilder.nextGenerationGrid(gridWithOneLiveCell())

        then:
        1 * cellManagerMock.updateCellState(0, CellType.alive)
    }

    void "counts neighbours correctly when one neighbour"() {
        given:
        def gridBuilder = new GridBuilder(cellManager: cellManagerMock)

        when:
        gridBuilder.nextGenerationGrid(gridWithTwoNeighbouringLiveCells())

        then:
        2 * cellManagerMock.updateCellState(1, CellType.alive)
    }

    @Unroll
    void "counts neighbours correctly when #neighboursCount neighbours"(grid, liveCells, neighboursCount) {
        given:
        def gridBuilder = new GridBuilder(cellManager: cellManagerMock)

        when:
        gridBuilder.nextGenerationGrid(grid)

        then:
        liveCells * cellManagerMock.updateCellState(neighboursCount, CellType.alive)

        where:
        grid                               | liveCells || neighboursCount
        emptyGrid()                        | 0         || 0
        gridWithOneLiveCell()              | 1         || 0
        gridWithTwoNeighbouringLiveCells() | 2         || 1
    }

    private ArrayList emptyGrid() {
        GenerationGridBuilder.aGenerationGridBuilder().withSize(3).build()
    }

    private ArrayList gridWithOneLiveCell() {
        GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 0).build()
    }

    private ArrayList gridWithTwoNeighbouringLiveCells() {
        GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 0).withAliveCell(0, 1).build()
    }
}
