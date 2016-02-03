import org.junit.Before
import org.junit.Ignore
import org.junit.Test

/**
 * Created by romina on 03.02.2016.
 */
class GameOfLifeTest {
    def gridOfCells

    @Before
    void setup() {
        gridOfCells = new GridOfCells()
    }

    @Test
    void "this generation grid of cells exists"() {
        assert gridOfCells.gameOfLifeGrid.size == 0
    }

    @Test
    void "for a 2x2 grid of cells with no live cell next generation grid has only dead cells(has 4 dead cells)"() {
        gridOfCells.gameOfLifeGrid[0] = [new GameOfLifeCell(false), new GameOfLifeCell(false)]
        gridOfCells.gameOfLifeGrid[1] = [new GameOfLifeCell(false), new GameOfLifeCell(false)]
        gridOfCells.gridEvolution()

        gridOfCells.countTypeOfCells()

        assert gridOfCells.liveCells == 0
        assert gridOfCells.deadCells == 4

    }

    @Test
    @Ignore
    void "for a 2x2 grid of cells with one live cell next generation grid has only dead cells(has 4 dead cells)"() {
        gridOfCells.gameOfLifeGrid[0] = [new GameOfLifeCell(true), new GameOfLifeCell(false)]
        gridOfCells.gameOfLifeGrid[1] = [new GameOfLifeCell(false), new GameOfLifeCell(false)]
        gridOfCells.gridEvolution()

        gridOfCells.countTypeOfCells()

        assert gridOfCells.liveCells == 0
        assert gridOfCells.deadCells == 4

    }


    @Test
    void "for a 2x2 grid of cells with two live cell next generation grid has only dead cells(has 4 dead cells)"() {
        /*   gridOfCells.gameOfLifeGrid[0]  = [ new GameOfLifeCell(true ), new GameOfLifeCell(true)]
           gridOfCells.gameOfLifeGrid[1] = [ new GameOfLifeCell(false), new GameOfLifeCell(false)]
           gridOfCells.gridEvolution()
           assert gridOfCells.liveCells == 0
           assert gridOfCells.deadCells == 4*/

    }

    @Test
    void "for a 2x2 grid of cells with three live cell next generation grid has only live cells(or has 4 live cells)"() {


    }

    @Test
    void "for a 2x2 grid of cells with four live cell next generation grid has 4 live cells"() {


    }

    @Test
    void "for a 3x3 grid of cells with one live cell next generation grid has no live cells(or has 0 live cells)"() {


    }


    @Test
    void "for a 3x3 grid of cells with two live cell next generation grid has no live cells(or has 0 live cells)"() {


    }


    @Test
    void "for a 3x3 grid of cells with one line live cells(3) next generation grid has no live cells(or has 0 live cells)"() {


    }


    @Test
    void "for a 3x3 grid of cells with one column live cells(3) next generation grid has no live cells(or has 0 live cells)"() {


    }


    @Test
    void "for a 3x3 grid of cells with 3 live cells next generation grid has no live cells(or has 0 live cells)"() {


    }


    @Test
    void "next generation grid decreases when cell is alive and has less than two live neighbours "() {

    }

    @Test
    void "next generation grid decreases when cell is alive and has more than three live neighbours "() {

    }

    @Test
    void "next generation grid grows when cell is alive and has two live neighbours "() {

    }


    @Test
    void "next generation grid grows when cell is alive and has three live neighbours "() {

    }

    @Test
    void "next generation grid grows when cell is dead has three live neighbours "() {

    }

// grid grows when cell is dead and horizontally neighbours and top vertical neighbours are alive
// grid grows when cell is dead and horizontally neighbours and bottom vertical neighbours are alive
// grid grows when cell is dead horizontally neighbours and top vertical neighbours are alive

    // grid grows when cell is dead and horizontally neighbours and top right diagonally neighbours are alive
    // grid grows when cell is dead and horizontally neighbours and bottom right diagonally neighbours are alive
// grid grows when cell is dead horizontally neighbours and top vertical neighbours are alive


}