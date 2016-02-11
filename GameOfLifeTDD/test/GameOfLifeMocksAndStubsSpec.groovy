import spock.lang.Specification

/**
 * Created by romina on 11.02.2016.
 */
class GameOfLifeMocksAndStubsSpec extends Specification {

    // Strict collaboration test using mock: universe.evolve() calls cell.evolve() only once
    def "universe with a cell delegates evolution to cell"() {
        given:
        def grid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).build()

        def gridBuilderMock = Mock(GridBuilder)
        def gameOfLife = new GameOfLife(gridBuilder: gridBuilderMock)

        when:
        gameOfLife.generationGridEvolution(grid)

        then:
        1 * gridBuilderMock.nextGenerationGrid(grid)
    }


    def "test stub for grid"() {
        given:
        def grid = []
        def evolvedGrid = ["irrelevant"]

        def gridStub = Mock(GridBuilder) {
            nextGenerationGrid(grid) >> evolvedGrid
        }

        def gameOfLife = new GameOfLife(gridBuilder: gridStub)

        when:
        def newGrid=gameOfLife.generationGridEvolution(grid)

        then:
        newGrid == evolvedGrid

    }
}
