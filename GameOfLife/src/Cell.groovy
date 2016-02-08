/**
 * Created by romina on 03.02.2016.
 */
class Cell {

    def state
    static int alive = 1
    static int dead = 0
    def cellXPos
    def cellYPos
    def aliveState
    def type


    Cell(int aliveState) {
        this.aliveState = aliveState
    }

    def neighboursMiddleCell(gameOfLifeGrid) {
        def allNeighbours = [] as Set
        allNeighbours.addAll(neighboursBottomLeftCornerCell(gameOfLifeGrid))
        allNeighbours.addAll(neighboursBottomRightCornerCell(gameOfLifeGrid))
        allNeighbours.addAll(neighboursTopLeftCornerCell(gameOfLifeGrid))
        allNeighbours.addAll(neighboursTopRightCornerCell(gameOfLifeGrid))
        return allNeighbours
    }

    def neighboursBottomRightCornerCell(gameOfLifeGrid) {
        [gameOfLifeGrid[cellXPos-1][cellYPos], gameOfLifeGrid[cellXPos-1][cellYPos-1],
         gameOfLifeGrid[cellXPos][cellYPos-1]]
    }

    def neighboursTopLeftCornerCell(gameOfLifeGrid) {
        [gameOfLifeGrid[cellXPos][cellYPos+1],
         gameOfLifeGrid[cellXPos+1][cellYPos], gameOfLifeGrid[cellXPos+1][cellYPos+1]]
    }

    def neighboursBottomLeftCornerCell(gameOfLifeGrid ) {
        [gameOfLifeGrid[cellXPos - 1][cellYPos], gameOfLifeGrid[cellXPos - 1][cellYPos+1],
         gameOfLifeGrid[cellXPos][cellYPos+1]]
    }

    def neighboursTopRightCornerCell(gameOfLifeGrid) {
        [gameOfLifeGrid[cellXPos][cellYPos - 1],
         gameOfLifeGrid[cellXPos + 1][cellYPos], gameOfLifeGrid[cellXPos + 1][cellYPos - 1]]
    }

    def neighboursTopMiddleEdgeCell(gameOfLifeGrid) {
        [gameOfLifeGrid[cellXPos][cellYPos - 1], gameOfLifeGrid[cellXPos][cellYPos + 1],
         gameOfLifeGrid[cellXPos + 1][cellYPos], gameOfLifeGrid[cellXPos + 1][cellYPos - 1], gameOfLifeGrid[cellXPos + 1][cellYPos + 1]]
    }

    def neighboursLeftMiddleEdgeCell(gameOfLifeGrid) {
        [gameOfLifeGrid[cellXPos][cellYPos + 1], gameOfLifeGrid[cellXPos - 1][cellYPos + 1],
         gameOfLifeGrid[cellXPos + 1][cellYPos + 1], gameOfLifeGrid[cellXPos + 1][cellYPos], gameOfLifeGrid[cellXPos - 1][cellYPos]]
    }

    def neighboursMiddleBottomEdgeCell(gameOfLifeGrid) {
        [gameOfLifeGrid[cellXPos][(cellYPos + 1)], gameOfLifeGrid[cellXPos - 1][cellYPos + 1],
         gameOfLifeGrid[cellXPos][cellYPos - 1], gameOfLifeGrid[cellXPos - 1][cellXPos - 1], gameOfLifeGrid[cellXPos - 1][cellYPos]]
    }

    boolean isMiddleCell(gridSize) {
        (cellXPos - 1) >= 0 && (cellYPos - 1) >= 0 && ((cellXPos + 1) <= (gridSize - 1)) && ((cellYPos + 1) <= (gridSize - 1))

    }

    boolean isBottomRightCorner(gridSize) {
        (cellYPos + 1) > (gridSize - 1) && (cellXPos + 1) > (gridSize - 1)
    }

    boolean isBottmLeftCorner(gridSize) {
        (cellYPos - 1) < 0 && (cellXPos + 1) > (gridSize - 1)
    }

    boolean isTopRightCornerCell(gridSize) {
        (cellXPos - 1) < 0 && (cellYPos + 1) > (gridSize - 1)
    }

    boolean isRightMiddleEdgeCell(gridSize) {
        (cellYPos + 1) > (gridSize - 1)
    }

    boolean isBottomMiddleEdgeCell(gridSize) {
        (cellXPos + 1) > (gridSize - 1)
    }

    boolean isLeftMiddleEdgeCell() {
        (cellYPos - 1) < 0

    }

    boolean isTopLeftCornerCell() {
        (cellXPos - 1) < 0 && (cellYPos - 1) < 0
    }

    boolean isTopMiddleEdgeCell() {
        def xPreviousPos = cellXPos - 1
        xPreviousPos < 0
    }

    String toString() {
        state ? "true" : "false"
    }

    def beAlive() {
        this.aliveState = Cell.alive
    }

    def beDead() {
        this.aliveState = Cell.dead
    }


    def neighboursMiddleRightEdgeCell(gameOfLifeGrid) {

        [gameOfLifeGrid[cellXPos][(cellYPos - 1)], gameOfLifeGrid[(cellXPos - 1)][(cellYPos - 1)],
         gameOfLifeGrid[(cellXPos - 1)][cellYPos], gameOfLifeGrid[(cellXPos + 1)][(cellYPos - 1)], gameOfLifeGrid[(cellXPos + 1)][cellYPos]]


    }
}
