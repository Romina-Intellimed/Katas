/**
 * Created by romina on 03.02.2016.
 */


class GameOfLifeEvolution {
    public static final int MINIMUM_LIVE_NEIGHBOURS = 2
    public static final int MAXIMUM_LIVE_NEIGHBOURS = 3
    def gameOfLifeGrid = []

    def cellEvolution(Cell actualCell) {

        def neighbours = getCellNeighbours(actualCell)
        isAlive(neighbours) ? actualCell.beAlive() : actualCell.beDead()
        return actualCell

    }

    private boolean isAlive(neighbours) {
        livingNeighboursNr(neighbours) >= MINIMUM_LIVE_NEIGHBOURS && livingNeighboursNr(neighbours) <= MAXIMUM_LIVE_NEIGHBOURS
    }

    private def livingNeighboursNr(neighbours) {
        neighbours.sum { it.aliveState }
    }

    private def getCellNeighbours(actualCell) {
        def cellPositionIncrement = 1

        def xPreviousPos = actualCell.cellXPos - cellPositionIncrement
        def yPreviousPos = actualCell.cellYPos - cellPositionIncrement
        def yNextPos = actualCell.cellYPos + cellPositionIncrement
        def xNextPos = actualCell.cellXPos + cellPositionIncrement

        if (actualCell.isBottomRightCorner(getGridSize())) {
            actualCell.neighboursBottomRightCornerCell(gameOfLifeGrid)
        } else if (actualCell.isMiddleCell(gridSize)) {
            actualCell.neighboursMiddleCell(gameOfLifeGrid)
        } else if (actualCell.isBottomMiddleEdgeCell(getGridSize())) {
           actualCell.neighboursMiddleBottomEdgeCell(gameOfLifeGrid)
        } else if(actualCell.isRightMiddleEdgeCell(getGridSize())){
            actualCell.neighboursMiddleRightEdgeCell(gameOfLifeGrid)
        } else if (actualCell.isTopLeftCornerCell()) {
            actualCell.neighboursTopLeftCornerCell(gameOfLifeGrid)
        } else if (actualCell.isBottmLeftCorner(getGridSize())) {
          actualCell.neighboursBottomLeftCornerCell(gameOfLifeGrid)
        } else if (actualCell.isTopRightCornerCell(getGridSize())) {
            actualCell.neighboursTopRightCornerCell(gameOfLifeGrid)
        } else if (actualCell.isTopMiddleEdgeCell()) {
            actualCell.neighboursTopMiddleEdgeCell(gameOfLifeGrid)
        } else if (actualCell.isLeftMiddleEdgeCell()) {
            actualCell.neighboursLeftMiddleEdgeCell(gameOfLifeGrid)
        }
    }


    private int getGridSize() {
        gameOfLifeGrid.size()
    }


}
