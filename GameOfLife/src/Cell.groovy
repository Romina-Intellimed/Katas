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
    def cellXPrev
    def cellYPrev
    def cellXNext
    def cellYNext
    TypeOfCell type



    Cell(int aliveState) {
        this.aliveState = aliveState
    }


    def getNeighboursCoordinates(){
        switch(type) {
            case TypeOfCell.bottomRightCorner:
                return [new Coordinates(getCellXPrev(),cellYPos),new Coordinates(getCellXPrev(),getCellYPrev()),new Coordinates(cellXPos,getCellYPrev())]
            case TypeOfCell.bottomMiddleEdge:
                return [new Coordinates(cellXPos,(getCellYNext())), new Coordinates(getCellXPrev(),getCellYNext()), new Coordinates(cellXPos,getCellYPrev()),
                new Coordinates(getCellXPrev(),getCellYPrev()), new Coordinates(getCellXPrev(),cellYPos)]
            case TypeOfCell.bottomLeftCorner:
                return [new Coordinates(getCellXPrev(), cellYPos),new Coordinates(getCellXPrev(),getCellYNext()), new Coordinates(cellXPos,getCellYNext())]
            case TypeOfCell.topLefCorner:
                return [new Coordinates(cellXPos,getCellYNext()), new Coordinates(getCellXNext(),cellYPos),new Coordinates(getCellXNext(),getCellYNext())]
            case TypeOfCell.topMiddleEdge:
                return [new Coordinates(cellXPos,getCellYPrev()),new Coordinates(cellXPos,getCellYNext()),
                new Coordinates(getCellXNext(),cellYPos), new Coordinates(getCellXNext(),getCellYPrev()),new Coordinates(getCellXNext(),getCellYNext())]
            case TypeOfCell.topRightCorner:
                return [new Coordinates(cellXPos,getCellYPrev()), new Coordinates(getCellXNext(),cellYPos), new Coordinates(getCellXNext(),getCellYPrev())]
            case TypeOfCell.rightMiddleEdge:
                return [new Coordinates(cellXPos,getCellYPrev()),new Coordinates(getCellXPrev(),getCellYPrev()),
                 new Coordinates(getCellXPrev(),cellYPos),new Coordinates(getCellXNext(),getCellYPrev(), new Coordinates(getCellXNext(),cellYPos))]
            case TypeOfCell.leftMiddleEdge:
                return [new Coordinates(cellXPos,getCellXNext()),new Coordinates(getCellXPrev(),getCellYNext()),new Coordinates(getCellXNext(),getCellYNext()),
                new Coordinates(getCellXNext(),cellYPos), new Coordinates(getCellXPrev(),cellYPos)]
            case TypeOfCell.middle:
                return [new Coordinates(getCellXPrev(),getCellYPrev()),new Coordinates(getCellXPrev(),cellYPos),new Coordinates(getCellYPrev(),getCellYNext()),
                        new Coordinates(cellXPos,getCellYPrev()),new Coordinates(cellXPos,getCellYNext()),new Coordinates(getCellXNext(),getCellYPrev()),
                        new Coordinates(getCellXNext(),cellYPos),new Coordinates(getCellXNext(),getCellYNext())
                ]
        }
    }

    def getCellXPrev() {
        cellXPrev= cellXPos - 1
    }

    def getCellYPrev() {
        cellYPrev= cellYPos-1
    }

    def getCellXNext() {
        cellXNext=cellXPos+1
    }

    def getCellYNext() {
        cellYNext= cellYPos+1
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
        [gameOfLifeGrid[getCellXPrev()][cellYPos], gameOfLifeGrid[getCellXPrev()][getCellYPrev()],
         gameOfLifeGrid[cellXPos][getCellYPrev()]]
    }

    def neighboursTopLeftCornerCell(gameOfLifeGrid) {
        [gameOfLifeGrid[cellXPos][cellYPos+1],
         gameOfLifeGrid[getCellXNext()][cellYPos], gameOfLifeGrid[getCellXNext()][getCellYNext()]]
    }

    def neighboursBottomLeftCornerCell(gameOfLifeGrid ) {
        [gameOfLifeGrid[getCellXPrev()][cellYPos], gameOfLifeGrid[getCellXPrev()][getCellYNext()],
         gameOfLifeGrid[cellXPos][getCellYNext()]]
    }

    def neighboursTopRightCornerCell(gameOfLifeGrid) {
        [gameOfLifeGrid[cellXPos][getCellYPrev()],
         gameOfLifeGrid[getCellXNext()][cellYPos], gameOfLifeGrid[getCellXNext()][getCellYPrev()]]
    }

    def neighboursTopMiddleEdgeCell(gameOfLifeGrid) {
        [gameOfLifeGrid[cellXPos][getCellYPrev()], gameOfLifeGrid[cellXPos][getCellYNext()],
         gameOfLifeGrid[getCellXNext()][cellYPos], gameOfLifeGrid[getCellXNext()][getCellYPrev()], gameOfLifeGrid[getCellXNext()][getCellYNext()]]
    }

    def neighboursLeftMiddleEdgeCell(gameOfLifeGrid) {
        [gameOfLifeGrid[cellXPos][getCellYNext()], gameOfLifeGrid[getCellXPrev()][getCellYNext()],
         gameOfLifeGrid[getCellXNext()][getCellYNext()], gameOfLifeGrid[getCellXNext()][cellYPos], gameOfLifeGrid[getCellXPrev()][cellYPos]]
    }

    def neighboursMiddleBottomEdgeCell(gameOfLifeGrid) {
        [gameOfLifeGrid[cellXPos][(getCellYNext())], gameOfLifeGrid[getCellXPrev()][getCellYNext()],
         gameOfLifeGrid[cellXPos][getCellYPrev()], gameOfLifeGrid[getCellXPrev()][getCellYPrev()], gameOfLifeGrid[getCellXPrev()][cellYPos]]
    }

    def neighboursMiddleRightEdgeCell(gameOfLifeGrid) {

        [gameOfLifeGrid[cellXPos][(getCellYPrev())], gameOfLifeGrid[(getCellXPrev())][(getCellYPrev())],
         gameOfLifeGrid[(getCellXPrev())][cellYPos], gameOfLifeGrid[(getCellXNext())][(getCellYPrev())], gameOfLifeGrid[(getCellXNext())][cellYPos]]


    }

    boolean isMiddleCell(gridSize) {
        (getCellXPrev()) >= 0 && (getCellYPrev()) >= 0 && ((getCellXNext()) <= (gridSize - 1)) && ((getCellYNext()) <= (gridSize - 1))

    }

    boolean isBottomRightCorner(gridSize) {
        (getCellYNext()) > (gridSize - 1) && (getCellXNext()) > (gridSize - 1)
    }

    boolean isBottmLeftCorner(gridSize) {
        (getCellYPrev()) < 0 && (getCellXNext()) > (gridSize - 1)
    }

    boolean isTopRightCornerCell(gridSize) {
        (getCellXPrev()) < 0 && (getCellYNext()) > (gridSize - 1)
    }

    boolean isRightMiddleEdgeCell(gridSize) {
        (getCellYNext()) > (gridSize - 1)
    }

    boolean isBottomMiddleEdgeCell(gridSize) {
        (getCellXNext()) > (gridSize - 1)
    }

    boolean isLeftMiddleEdgeCell() {
        (getCellYPrev()) < 0

    }

    boolean isTopLeftCornerCell() {
        (getCellXPrev()) < 0 && (getCellYPrev()) < 0
    }

    boolean isTopMiddleEdgeCell() {
        def xPreviousPos = getCellXPrev()
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



}
