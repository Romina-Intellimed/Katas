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
        def actualGrid = grid2x2WithDeadCells()
        when:
        def expectedGrid = gameOfLife.generationGridEvolution(actualGrid)
        then:
        expectedGrid == grid2x2WithDeadCells()
    }


    void "a 2x2 grid with one live cells will have no live cell in next generation"() {
        given:
        def actualGrid = grid2x2FirstCellAlive()
        when:
        def expectedGrid = gameOfLife.generationGridEvolution(actualGrid)
        then:
        expectedGrid == grid2x2WithDeadCells()
    }

    void "a 2x2 grid with two live cells will have no live cell in next generation"() {
        given:
        def actualGrid = grid2x2FirstLineAlive()
        when:
        def expectedGrid = gameOfLife.generationGridEvolution(actualGrid)
        then:
        expectedGrid == grid2x2WithDeadCells()

    }

    void "a 2x2 grid with three live cells will have four live cells in next generation"() {
        given:
        def actualGrid = grid2x2OneCellDead()
        when:
        def expectedGrid = gameOfLife.generationGridEvolution(actualGrid)
        then:
        expectedGrid == grid2x2WithLiveCells()
    }

    void "a 2x2 grid with four live cells will have no live cells in next generation"() {

    }



    private def grid2x2FirstCellAlive() {
        [rowWithFirstCellAliveOutOf2(), rowWith2DeadCells()]
    }

    private def grid2x2OneCellDead(){
        [rowWith2LiveCells(), rowWithFirstCellAliveOutOf2()]
    }
    private def grid2x2FirstLineAlive() {
        [rowWith2LiveCells(), rowWith2DeadCells()]
    }

    private def rowWithFirstCellAliveOutOf2() {
        [CellType.alive, CellType.dead]
    }

    private def rowWith2DeadCells() {
        [CellType.dead, CellType.dead]
    }

    private def rowWith2LiveCells() {
        [CellType.alive, CellType.alive]
    }

    private def grid2x2WithDeadCells() {
        [rowWith2DeadCells(), rowWith2DeadCells()]
    }

    private def grid2x2WithLiveCells() {
        [rowWith2LiveCells(), rowWith2LiveCells()]
    }




    void "a 3x3 grid with one live cells will have no live cell in next generation"() {

    }


    void "a 3x3 grid with two live cells will have no live cell in next generation"() {

    }


    void "a 3x3 grid with three live cells on the position: (CellType.dead,CellType.dead),(CellType.dead,CellType.alive),(CellType.dead,2) will have one live cell in next generation"() {

    }

    void "a 3x3 grid with three live cells on the position: (CellType.dead,CellType.dead),(CellType.dead,CellType.alive),(CellType.alive,CellType.dead) will have four live cells in next generation"() {

    }

    void "a 3x3 grid with three live cells on the position: (CellType.dead,CellType.dead),(CellType.dead,CellType.alive),(CellType.alive,CellType.alive) will have six live cells in next generation"() {

    }


}
