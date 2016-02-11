/**
 * Created by romina on 09.02.2016.
 */
class Cell {


    def updateCellState(aliveNeighbours, cellState) {
        if ((aliveNeighbours < 2 || aliveNeighbours > 3) && isAlive(cellState))
            return CellType.dead
        if ((aliveNeighbours == 2 || aliveNeighbours == 3) && isAlive(cellState))
            return CellType.alive
        if (aliveNeighbours == 3 && !isAlive(cellState))
            return CellType.alive
        if (aliveNeighbours != 3 && !isAlive(cellState))
            return CellType.dead

    }

    private boolean isAlive(cellType) {
        cellType == CellType.alive
    }
}
