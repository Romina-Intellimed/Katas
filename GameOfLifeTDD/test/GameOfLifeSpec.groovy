import spock.lang.Ignore
import spock.lang.Specification

/**
 * Created by romina on CellType.dead9.CellType.dead2.2CellType.deadCellType.alive6.
 */
class GameOfLifeSpec extends Specification {

    GameOfLife gameOfLife

    void setup() {
        gameOfLife = new GameOfLife()
    }

    void "a 2x2 grid with no live cells will have no live cell in next generation"() {
        given:
        def initialGrid = grid2x2WithDeadCells()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == grid2x2WithDeadCells()
    }


    void "a 2x2 grid with one live cells will have no live cell in next generation"() {
        given:
        def initialGrid = grid2x2FirstCellAlive()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == grid2x2WithDeadCells()
    }

    void "a 2x2 grid with two live cells will have no live cell in next generation"() {
        given:
        def initialGrid = grid2x2FirstLineAlive()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == grid2x2WithDeadCells()

    }

    void "a 2x2 grid with three live cells will have four live cells in next generation"() {
        given:
        def initialGrid = grid2x2OneCellDead()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == grid2x2WithLiveCells()
    }

    void "a 2x2 grid with four live cells will have no live cells in next generation"() {
        given:
        def initialGrid = grid2x2WithLiveCells()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == grid2x2WithLiveCells()
    }


    private def grid2x2FirstCellAlive() {
        GenerationGridBuilder.aGenerationGridBuilder().withAliveCell(0, 0).build()
    }

    private def grid2x2OneCellDead() {
        GenerationGridBuilder.aGenerationGridBuilder().withAliveCell(0, 0).withAliveCell(0, 1).withAliveCell(1, 0).build()
    }

    private def grid2x2FirstLineAlive() {
        GenerationGridBuilder.aGenerationGridBuilder().withAliveCell(0, 0).withAliveCell(0, 1).build()
    }

    private def grid2x2WithDeadCells() {
        GenerationGridBuilder.aGenerationGridBuilder().build()
    }

    private def grid2x2WithLiveCells() {
        GenerationGridBuilder.aGenerationGridBuilder().withAliveCell(0, 0).withAliveCell(0, 1).withAliveCell(1,0).withAliveCell(1,1).build()
    }

    private def grid3x3WithDeadCells() {
        GenerationGridBuilder.aGenerationGridBuilder().withSize(3).build()
    }


    void "a 3x3 grid with no live cells will have no live cell in next generation"() {
        given:
        def initialGrid = grid3x3WithDeadCells()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == grid3x3WithDeadCells()

    }

    void "a 3x3 grid with one live cells will have no live cell in next generation"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 1).build()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == grid3x3WithDeadCells()
    }


    void "a 3x3 grid with two live cells will have no live cell in next generation"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 1).withAliveCell(0, 2).build()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == grid3x3WithDeadCells()

    }


    void "a 3x3 grid with three live cells on the position: (0,0),(0,1),(0,2) will have two live cells in next generation on (0,1)cand (1,1) position"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 0).withAliveCell(0, 1).withAliveCell(0, 2).build()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 1).withAliveCell(1,1).build()

    }

    void "a 3x3 grid with three live cells on the position: (0,0),(0,1),(1,0) will have four live cells in next generation"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 0).withAliveCell(1, 0).withAliveCell(0, 1).build()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 0).withAliveCell(0,1).withAliveCell(1,1).withAliveCell(1,0).build()
    }

    void "a 3x3 grid with three live cells on the position: (0,0),(0,1),(1,1) will have four live cells in next generation"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 0).withAliveCell(1,1).withAliveCell(0, 1).build()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 0).withAliveCell(0,1).withAliveCell(1,1).withAliveCell(1,0).build()
    }

    void "a 3x3 grid with three live cells on the position: (0,0),(0,1),(1,2) will have one live cell in next generation"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 0).withAliveCell(0,1).withAliveCell(1, 2).build()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == GenerationGridBuilder.aGenerationGridBuilder().withAliveCell(0, 1).withAliveCell(1,1).withSize(3).build()

    }

    void "a 3x3 grid with three live cells on the position: (0,0),(0,1),(2,0) will have no live cell in next generation"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 0).withAliveCell(0,1).withAliveCell(2, 0).build()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(1, 0).withAliveCell(1,1).build()

    }

    void "a 3x3 grid with three live cells on the position: (0,0),(0,1),(2,1) will have no live cell in next generation"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 0).withAliveCell(0,1).withAliveCell(2, 1).build()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(1, 0).withAliveCell(1,1).build()

    }

    void "a 3x3 grid with three live cells on the position: (0,0),(0,1),(2,2) will have no live cell in next generation"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 0).withAliveCell(0,1).withAliveCell(2, 2).build()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(1,1).build()

    }

    void "a 3x3 grid with three live cells on the position: (1,0),(1,1),(1,2) will have three live cells in next generation"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(1, 0).withAliveCell(1,1).withAliveCell(1, 2).build()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(1,1).withAliveCell(0, 1).withAliveCell(2,1).build()

    }

    void "a 3x3 grid with three live cells on the position: (2,0),(2,1),(2,2) will have one live cell in next generation"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(2, 0).withAliveCell(2,1).withAliveCell(2, 2).build()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(1,1).withAliveCell(2,1).build()
    }

    void "a 3x3 grid with three live cells on the position: (0,1),(1,1),(2,1) will have three live cells in next generation"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 1).withAliveCell(2,1).withAliveCell(1, 1).build()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(1,1).withAliveCell(1,0).withAliveCell(1,2).build()
    }

    void "a 3x3 grid with three live cells on the position: (0,2),(1,2),(2,2) will have two live cells in next generation"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 1).withAliveCell(2,1).withAliveCell(1, 1).build()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(1,1).withAliveCell(1,0).withAliveCell(1,2).build()

    }

    void "a 3x3 grid with three live cells on the position: (0,0),(1,0),(2,0) will have two live cells in next generation"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 0).withAliveCell(1,0).withAliveCell(2, 0).build()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(1,1).withAliveCell(1,0).build()

    }

    void "a 3x3 grid with three live cells on the position: (0,0),(1,1),(2,2) will have one live cell in next generation"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 0).withAliveCell(1,1).withAliveCell(2, 2).build()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(1,1).build()
    }

    void "a 3x3 grid with three live cells on the position: (2,0),(1,1),(0,2) will have one live cell in next generation"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(2, 0).withAliveCell(1,1).withAliveCell(0, 2).build()
        when:
        def actualGrid = gameOfLife.generationGridEvolution(initialGrid)
        then:
        actualGrid == GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(1,1).build()

    }


    @Ignore
    void "test system array Copy "() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 1).build()
        def newGrid = []
        when:
        def result = System.arraycopy(initialGrid, 0, newGrid, 0, initialGrid.size())
        then:
        initialGrid == newGrid
        result
    }

    @Ignore
    void "test surounded grid with dead cells"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 1).build()
        when:
        def newGrid = GridBuilder.surroundGridwithDeadCells(initialGrid)
        then:
        newGrid == GenerationGridBuilder.aGenerationGridBuilder().withSize(5).withAliveCell(1, 2).build()
    }

    @Ignore
    void "test number of dead neighbours cells"() {
        given:
        def initialGrid = GenerationGridBuilder.aGenerationGridBuilder().withSize(3).withAliveCell(0, 1).build()
        when:
        def numberOfDeadNeigbours = GridBuilder.countAliveCellNeighbours(initialGrid, 1, 2)
        then:
        numberOfDeadNeigbours == 0
    }


    void "test adding positions to array"(){
        given:
        def initialArray=[]
        when:
        initialArray.add([1,2])
        initialArray.add([2,3])
        def finalArray=initialArray
        then:
        finalArray == [[1,2],[2,3]]
    }

}
