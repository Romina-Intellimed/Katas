import spock.lang.Specification

/**
 * Created by romina on 12.02.2016.
 */
class GridBuilderSpec extends Specification {

    def GridBuilder gridBuilder

    def setup() {
        gridBuilder = new GridBuilder()
    }

    void "test next generation grid state"() {
        given:
        def grid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 0).withAliveCell(1, 0).withAliveCell(2, 0).build()

        def cellMock = Mock(CellManager)
        def gridBuilder = new GridBuilder(cellManager: cellMock)
        when:
        gridBuilder.nextGenerationGrid(grid)
        then:
        9 * cellMock.updateCellState(*_)


    }


}
