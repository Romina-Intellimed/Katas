/**
 * Created by romina on 09.02.2016.
 */
class Cell {


    def static updateCellState(aliveNeighbours, cell) {
        if ((aliveNeighbours < 2 || aliveNeighbours > 3) && isAlive(cell))
            return CellType.dead
        if ((aliveNeighbours == 2 || aliveNeighbours == 3) && isAlive(cell))
            return CellType.alive
        if (aliveNeighbours == 3 && !isAlive(cell))
            return CellType.alive
        if (aliveNeighbours != 3 && !isAlive(cell))
            return CellType.dead

    }

    private static boolean isAlive(cellType) {
        cellType == CellType.alive
    }
}
