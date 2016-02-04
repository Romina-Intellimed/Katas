/**
 * Created by romina on 03.02.2016.
 */


class GridOfCells {
    //GameOfLifeCell[][] gameOfLifeGrid
    public static final int MINIMUM_LIVE_NEIGHBOURS = 2
    public static final int MAXIMUM_LIVE_NEIGHBOURS = 3
    def gameOfLifeGrid = []
    def liveCells = 0;
    def deadCells = 0;
    static def MIN_X = 0
    static def MIN_Y = 0
    def MAX_X = gameOfLifeGrid.size()
    def MAX_Y = gameOfLifeGrid.size()

    def cellEvolution(GameOfLifeCell actualCell) {

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

         if(isBottomRightCorner(yNextPos, xNextPos)){
             neighboursBottomRightCornerCell(xPreviousPos, actualCell, yPreviousPos)
        } else  if (isMiddleCell(xPreviousPos, yPreviousPos)) {
             neighboursMiddleCell(xPreviousPos, yPreviousPos, actualCell, yNextPos, xNextPos)
        } else if(isTopLeftCorner(xPreviousPos, yPreviousPos))  {
             neighboursTopLeftCornerCell(actualCell, yNextPos, xNextPos)
        } else if(isBottmLeftCorner(yPreviousPos, xNextPos)){
             neighboursBottomLeftCornerCell(xPreviousPos, actualCell, yNextPos)
        }



    }

    private boolean isBottomRightCorner(yNextPos, xNextPos) {
        yNextPos > (gameOfLifeGrid.size() - 1) && xNextPos > (gameOfLifeGrid.size() - 1)
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
        [gameOfLifeGrid[xPreviousPos][yPreviousPos], gameOfLifeGrid[xPreviousPos][actualCell.cellYPos], gameOfLifeGrid[xPreviousPos][yNextPos],
         gameOfLifeGrid[actualCell.cellXPos][yPreviousPos], gameOfLifeGrid[actualCell.cellXPos][yNextPos],
         gameOfLifeGrid[xNextPos][yPreviousPos], gameOfLifeGrid[xNextPos][actualCell.cellYPos], gameOfLifeGrid[xNextPos][yNextPos]]
    }

    private def neighboursBottomRightCornerCell(xPreviousPos, actualCell, yPreviousPos) {
        [gameOfLifeGrid[xPreviousPos][actualCell.cellYPos], gameOfLifeGrid[xPreviousPos][yPreviousPos],
         gameOfLifeGrid[actualCell.cellXPos][yPreviousPos]]
    }

    private boolean isBottmLeftCorner(yPreviousPos, xNextPos) {
        yPreviousPos < 0 && xNextPos > (gameOfLifeGrid.size() - 1)
    }

    private boolean isTopLeftCorner(xPreviousPos, yPreviousPos) {
        xPreviousPos < 0 && yPreviousPos < 0
    }

    private boolean isMiddleCell(xPreviousPos, yPreviousPos) {
        xPreviousPos >= 0 && yPreviousPos >= 0
    }


    def countNeighboursLiveCells(thisPosX, thisPosY) {
        def neighboursLiveCells = 0
        int startPosX = (thisPosX - 1 < MIN_X) ? thisPosX : thisPosX - 1;
        int startPosY = (thisPosY - 1 < MIN_Y) ? thisPosY : thisPosY - 1;
        int endPosX = (thisPosX + 1 > MAX_X) ? thisPosX : thisPosX + 1;
        int endPosY = (thisPosY + 1 > MAX_Y) ? thisPosY : thisPosY + 1;
        println " thisPosX = ${thisPosX} and thisPosY=${thisPosY}"

        for (int rowNum = startPosX; rowNum <= endPosX; rowNum++) {
            for (int colNum = startPosY; colNum <= endPosY; colNum++) {
                println " cell with rowNum = ${rowNum} and colNum=${colNum} is ${gameOfLifeGrid[rowNum][colNum]}"
                if (gameOfLifeGrid[rowNum][colNum].state == true)
                    neighboursLiveCells++

            }
        }

        return neighboursLiveCells

    }

    def gridEvolution() {
        println "grid: ${gameOfLifeGrid}"
        (gameOfLifeGrid.size()).times { i ->
            (gameOfLifeGrid.size()).times { j ->
                println " liveCells = ${liveCells} and deadCells=${deadCells} "
                if (gameOfLifeGrid[i][j].state == true && (countNeighboursLiveCells(i, j) == 2 || countNeighboursLiveCells(i, j) == 3)) {
                    gameOfLifeGrid[i][j].state == true
                    println "neighbours live cells: ${countNeighboursLiveCells(i, j)}"
                } else if (gameOfLifeGrid[i][j].state == true && countNeighboursLiveCells(i, j) < 2) {
                    gameOfLifeGrid[i][j].state == false
                } else if (gameOfLifeGrid[i][j].state == true && countNeighboursLiveCells(i, j) > 3) {
                    gameOfLifeGrid[i][j].state == false
                } else if (gameOfLifeGrid[i][j].state == false && countNeighboursLiveCells(i, j) == 3) {
                    gameOfLifeGrid[i][j].state == true
                } else if (gameOfLifeGrid[i][j].state == false && (countNeighboursLiveCells(i, j) < 2 || countNeighboursLiveCells(i, j) > 3)) {
                    gameOfLifeGrid[i][j].state == false

                }
            }
        }
        println "grid: ${gameOfLifeGrid}"
        return gameOfLifeGrid;
    }

    def countTypeOfCells() {
        gameOfLifeGrid.size().times { i ->
            gameOfLifeGrid.size().times { j ->
                if (gameOfLifeGrid[i][j].state == false)
                    deadCells++
                else if (gameOfLifeGrid[i][j].state == true)
                    liveCells++
            }
        }
    }


}
