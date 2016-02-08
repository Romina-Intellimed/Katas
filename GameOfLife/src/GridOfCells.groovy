/**
 * Created by romina on 03.02.2016.
 */


class GridOfCells {
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
            neighboursBottomRightCornerCell(xPreviousPos, actualCell, yPreviousPos)
        } else if (isMiddleCell(xPreviousPos, yPreviousPos, xNextPos, yNextPos)) {
            neighboursMiddleCell(xPreviousPos, yPreviousPos, actualCell, yNextPos, xNextPos)
        } else if (actualCell.isBottomMiddleEdgeCell(getGridSize())) {
            neighboursMiddleBottomEdgeCell(actualCell, yNextPos, xPreviousPos, yPreviousPos)
        } else if(actualCell.isRightMiddleEdgeCell(getGridSize())){
            neighboursMiddleRightEdgeCell(actualCell, yPreviousPos, xPreviousPos, xNextPos)
        } else if (actualCell.isTopLeftCornerCell()) {
            neighboursTopLeftCornerCell(actualCell, yNextPos, xNextPos)
        } else if (actualCell.isBottmLeftCorner(getGridSize())) {
            neighboursBottomLeftCornerCell(xPreviousPos, actualCell, yNextPos)
        } else if (actualCell.isTopRightCornerCell(getGridSize())) {
            neighboursTopRightCornerCell(actualCell, yPreviousPos, xNextPos)
        } else if (actualCell.isTopMiddleEdgeCell()) {
            neighboursTopMiddleEdgeCell(actualCell, yPreviousPos, yNextPos, xNextPos)
        } else if (actualCell.isLeftMiddleEdgeCell()) {
            neighboursLeftMiddleEdgeCell(actualCell, yNextPos, xPreviousPos, xNextPos)
        }
    }


    private int getGridSize() {
        gameOfLifeGrid.size()
    }


    private boolean isMiddleCell(xPreviousPos, yPreviousPos, xNextPos, yNextPos) {
        xPreviousPos >= 0 && yPreviousPos >= 0 && (xNextPos <= (gameOfLifeGrid.size()-1)) && (yNextPos <= (gameOfLifeGrid.size() -1))
    }

    private def neighboursMiddleRightEdgeCell(actualCell, yPreviousPos, xPreviousPos, xNextPos) {
        [gameOfLifeGrid[actualCell.cellXPos][yPreviousPos], gameOfLifeGrid[xPreviousPos][yPreviousPos],
         gameOfLifeGrid[xPreviousPos][actualCell.cellYPos], gameOfLifeGrid[xNextPos][yPreviousPos], gameOfLifeGrid[xNextPos][actualCell.cellYPos]]
    }

    private def neighboursMiddleBottomEdgeCell(actualCell, yNextPos, xPreviousPos, yPreviousPos) {
        [gameOfLifeGrid[actualCell.cellXPos][yNextPos], gameOfLifeGrid[xPreviousPos][yNextPos],
         gameOfLifeGrid[actualCell.cellXPos][yPreviousPos], gameOfLifeGrid[xPreviousPos][yPreviousPos], gameOfLifeGrid[xPreviousPos][actualCell.cellYPos]]
    }

    private def neighboursLeftMiddleEdgeCell(actualCell, yNextPos, xPreviousPos, xNextPos) {
        [gameOfLifeGrid[actualCell.cellXPos][yNextPos], gameOfLifeGrid[xPreviousPos][yNextPos],
         gameOfLifeGrid[xNextPos][yNextPos], gameOfLifeGrid[xNextPos][actualCell.cellYPos], gameOfLifeGrid[xPreviousPos][actualCell.cellYPos]]
    }

    private def neighboursTopMiddleEdgeCell(actualCell, yPreviousPos, yNextPos, xNextPos) {
        [gameOfLifeGrid[actualCell.cellXPos][yPreviousPos], gameOfLifeGrid[actualCell.cellXPos][yNextPos],
         gameOfLifeGrid[xNextPos][actualCell.cellYPos], gameOfLifeGrid[xNextPos][yPreviousPos], gameOfLifeGrid[xNextPos][yNextPos]]
    }

    private def neighboursTopRightCornerCell(actualCell, yPreviousPos, xNextPos) {
        [gameOfLifeGrid[actualCell.cellXPos][yPreviousPos],
         gameOfLifeGrid[xNextPos][actualCell.cellYPos], gameOfLifeGrid[xNextPos][yPreviousPos]]
    }

    private def neighboursBottomLeftCornerCell(xPreviousPos, actualCell, yNextPos) {
        [gameOfLifeGrid[xPreviousPos][actualCell.cellYPos], gameOfLifeGrid[xPreviousPos][yNextPos],
         gameOfLifeGrid[actualCell.cellXPos][yNextPos]]
    }

    private def neighboursTopLeftCornerCell(actualCell, yNextPos, xNextPos) {
        [gameOfLifeGrid[actualCell.cellXPos][yNextPos],
         gameOfLifeGrid[xNextPos][actualCell.cellYPos], gameOfLifeGrid[xNextPos][yNextPos]]
    }

    private def neighboursMiddleCell(xPreviousPos, yPreviousPos, actualCell, yNextPos, xNextPos) {
        def allNeighbours = [] as Set
        allNeighbours.addAll(neighboursBottomLeftCornerCell(xPreviousPos, actualCell, yNextPos))
        allNeighbours.addAll(neighboursBottomRightCornerCell(xPreviousPos, actualCell, yPreviousPos))
        allNeighbours.addAll(neighboursTopLeftCornerCell(actualCell, yNextPos, xNextPos))
        allNeighbours.addAll(neighboursTopRightCornerCell(actualCell, yPreviousPos, xNextPos))
        return allNeighbours
    }

    private def neighboursBottomRightCornerCell(xPreviousPos, actualCell, yPreviousPos) {
        [gameOfLifeGrid[xPreviousPos][actualCell.cellYPos], gameOfLifeGrid[xPreviousPos][yPreviousPos],
         gameOfLifeGrid[actualCell.cellXPos][yPreviousPos]]
    }


}
