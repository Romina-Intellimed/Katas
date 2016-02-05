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

    def resetGrid() {
        gridOfCells.gameOfLifeGrid = [[new GameOfLifeCell(GameOfLifeCell.dead), new GameOfLifeCell(GameOfLifeCell.dead), new GameOfLifeCell(GameOfLifeCell.dead)],
                                      [new GameOfLifeCell(GameOfLifeCell.dead), new GameOfLifeCell(GameOfLifeCell.dead), new GameOfLifeCell(GameOfLifeCell.dead)],
                                      [new GameOfLifeCell(GameOfLifeCell.dead), new GameOfLifeCell(GameOfLifeCell.dead), new GameOfLifeCell(GameOfLifeCell.dead)]]

        return gridOfCells.gameOfLifeGrid

    }


    @Test
    void "a middle living cell with fewer than 2 live neighbours dies"() {
        def newGrid = resetGrid()

        newGrid = setInGridALiveCell(newGrid, 1, 1)
        newGrid = setInGridALiveCell(newGrid, 1, 0)

        Object actualCell = actualCellEvolution(gridOfCells, 1, 1)

        assert GameOfLifeCell.dead == actualCell.aliveState
    }

    @Test
    void "a middle living cell with 2 live neighbours lives"() {
        def newGrid = resetGrid()

        newGrid = setInGridALiveCell(newGrid, 1, 1)
        newGrid = setInGridALiveCell(newGrid, 1, 0)
        newGrid = setInGridALiveCell(newGrid, 0, 0)
        Object actualCell = actualCellEvolution(gridOfCells, 1, 1)

        assert GameOfLifeCell.alive == actualCell.aliveState
    }

    @Test
    void "a middle living cell with 3 live neighbours lives"() {
        def newGrid = resetGrid()

        newGrid = setInGridALiveCell(newGrid, 1, 1)

        newGrid = setInGridALiveCell(newGrid, 1, 0)
        newGrid = setInGridALiveCell(newGrid, 0, 0)
        newGrid = setInGridALiveCell(newGrid, 0, 1)

        Object actualCell = actualCellEvolution(gridOfCells, 1, 1)
        assert GameOfLifeCell.alive == actualCell.aliveState
    }

    @Test
    void "a middle living cell with 4 live neighbours dies"() {
        def newGrid = resetGrid()

        newGrid = setInGridALiveCell(newGrid, 1, 1)

        newGrid = setInGridALiveCell(newGrid, 1, 0)
        newGrid = setInGridALiveCell(newGrid, 0, 0)
        newGrid = setInGridALiveCell(newGrid, 2, 1)
        newGrid = setInGridALiveCell(newGrid, 0, 1)

        Object actualCell = actualCellEvolution(gridOfCells, 1, 1)
        assert GameOfLifeCell.dead == actualCell.aliveState

    }

    @Test
    void "the upper left corner living cell with less than 2 living neighbours dies"() {
        def newGrid = resetGrid()

        setInGridALiveCell(newGrid, 0, 0)

        Object actualCell = actualCellEvolution(gridOfCells, 0, 0)
        assert GameOfLifeCell.dead == actualCell.aliveState

    }





    @Test
    void "the bottom left corner living cell with less than 2 living neighbours dies"() {
        def newGrid = resetGrid()

        setInGridALiveCell(newGrid, 2, 0)

        Object actualCell = actualCellEvolution(gridOfCells, 2, 0)
        assert GameOfLifeCell.dead == actualCell.aliveState
    }


    @Test
    void "the bottom right corner living cell with less than 2 living neighbours dies"() {
        def newGrid = resetGrid()

        setInGridALiveCell(newGrid, 2, 2)

        Object actualCell = actualCellEvolution(gridOfCells, 2, 2)
        assert GameOfLifeCell.dead == actualCell.aliveState
    }

    @Test
    void "the top right corner living cell with less than 2 living neighbours dies"() {
        def newGrid = resetGrid()

        setInGridALiveCell(newGrid, 0, 2)

        Object actualCell = actualCellEvolution(gridOfCells, 0, 2)
        assert GameOfLifeCell.dead == actualCell.aliveState
    }


    @Test
    void "the middle top edge living cell with less than 2 living neighbours dies"() {
        def newGrid = resetGrid()

        setInGridALiveCell(newGrid, 0, 1)

        Object actualCell = actualCellEvolution(gridOfCells, 0, 1)
        assert GameOfLifeCell.dead == actualCell.aliveState
    }

    @Test
    void "the middle left edge living cell with less than 2 living neighbours dies"() {
        def newGrid = resetGrid()

        newGrid = setInGridALiveCell(newGrid, 1, 0)
        setInGridALiveCell(newGrid, 1, 1)
        Object actualCell = actualCellEvolution(gridOfCells, 1, 0)
        assert GameOfLifeCell.dead == actualCell.aliveState
    }

    @Test
    void "the bottom middle edge living cell with less than 2 living neighbours dies"() {
        def newGrid = resetGrid()
        setInGridALiveCell(newGrid, 2, 1)
        Object actualCell = actualCellEvolution(gridOfCells, 2, 1)
        assert GameOfLifeCell.dead == actualCell.aliveState
    }


    @Test
    void "the right middle edge living cell with less than 2 living neighbours dies"() {
        def newGrid = resetGrid()
        setInGridALiveCell(newGrid, 1, 2)
        Object actualCell = actualCellEvolution(gridOfCells, 1, 2)
        assert GameOfLifeCell.dead == actualCell.aliveState
    }

    def setInGridALiveCell(newGrid, x, y) {
        newGrid[x][y].beAlive()
        return newGrid
    }

    private Object actualCellEvolution(gridOfCells, x, y) {
        def testedCell = gridOfCells.gameOfLifeGrid[x][y]
        testedCell.cellXPos = x
        testedCell.cellYPos = y
        def actualCell = gridOfCells.cellEvolution(testedCell)
        actualCell
    }














    @Test
    void "test out of bounds for groovy grid"() {
        def grid = [[0, 1], [0, 0]]
        assert 0 == grid[-1][0]
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