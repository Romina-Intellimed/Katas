import spock.lang.Specification
import spock.lang.Unroll

class CellManagerSpec extends Specification {

    def cellManager

    def setup() {
        cellManager = new CellManager()
    }

    @Unroll
    def "#isAliveNow cell with #cellsCount neighbours will be #shouldBeAlive"(isAliveNow, cellsCount, shouldBeAlive) {
        when:
        def isAlive = cellManager.updateCellState(cellsCount, isAliveNow)

        then:
        isAlive == shouldBeAlive

        where:
        isAliveNow     | cellsCount || shouldBeAlive
        CellType.alive | 1          || CellType.dead
        CellType.alive | 2          || CellType.alive
        CellType.alive | 3          || CellType.alive
        CellType.alive | 4          || CellType.dead
    }
}
