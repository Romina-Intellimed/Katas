import java.lang.reflect.Type

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

        if (actualCell.isBottomRightCorner(getGridSize())) {
            actualCell.type = TypeOfCell.bottomRightCorner
            actualCell.neighboursBottomRightCornerCell(gameOfLifeGrid)
        } else if (actualCell.isMiddleCell(gridSize)) {
            actualCell.type=TypeOfCell.middle
            actualCell.neighboursMiddleCell(gameOfLifeGrid)
        } else if (actualCell.isBottomMiddleEdgeCell(getGridSize())) {
            actualCell.type = TypeOfCell.bottomMiddleEdge
            actualCell.neighboursMiddleBottomEdgeCell(gameOfLifeGrid)
        } else if(actualCell.isRightMiddleEdgeCell(getGridSize())){
            actualCell.type=TypeOfCell.rightMiddleEdge
            actualCell.neighboursMiddleRightEdgeCell(gameOfLifeGrid)
        } else if (actualCell.isTopLeftCornerCell()) {
            actualCell.type=TypeOfCell.topLefCorner
            actualCell.neighboursTopLeftCornerCell(gameOfLifeGrid)
        } else if (actualCell.isBottmLeftCorner(getGridSize())) {
            actualCell.type=TypeOfCell.bottomLeftCorner
            actualCell.neighboursBottomLeftCornerCell(gameOfLifeGrid)
        } else if (actualCell.isTopRightCornerCell(getGridSize())) {
            actualCell.type=TypeOfCell.topRightCorner
            actualCell.neighboursTopRightCornerCell(gameOfLifeGrid)
        } else if (actualCell.isTopMiddleEdgeCell()) {
            actualCell.type=TypeOfCell.topMiddleEdge
            actualCell.neighboursTopMiddleEdgeCell(gameOfLifeGrid)
        } else if (actualCell.isLeftMiddleEdgeCell()) {
            actualCell.type=TypeOfCell.leftMiddleEdge
            actualCell.neighboursLeftMiddleEdgeCell(gameOfLifeGrid)
        }
    }


    private int getGridSize() {
        gameOfLifeGrid.size()
    }


}
