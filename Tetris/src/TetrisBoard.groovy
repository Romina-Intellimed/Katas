/**
 * Created by romina on 24.02.2016.
 */
class TetrisBoard {

    def board = []
    def boardRows = 1
    def boardColumns = 0

    def isEmpty() {
        return board.isEmpty()
    }

    def hasEmptySquares() {
        board.size().times { rowIndex ->
            board[rowIndex] = []
            board.size().times { colIndex ->
                if (board[rowIndex][colIndex] != 0)
                    return false
            }
        }
        return true
    }

    def initTheBoard(rows, columns) {
        boardRows = rows
        boardColumns = columns
        rows.times { rowIndex ->
            board[rowIndex] = []
            columns.times { colIndex ->
                board[rowIndex][colIndex] = 0
            }

        }
        return board
    }


    def addBlock(xPos, yPos) {
        board[xPos][yPos] = 1

    }

    def removeBlock(xPos, yPos) {
        board[xPos][yPos] = 0
    }

    def getBlock(xPos, yPos) {
        return board[xPos][yPos]
    }


}
