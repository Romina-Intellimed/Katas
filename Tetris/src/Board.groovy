/**
 * Created by romina on 17.02.2016.
 */
class Board {

    def board = []
    def rows = 1
    def columns = 0


    def isEmpty() {
        return board.isEmpty()
    }


    def initTheBoard(rows, columns) {
        this.rows = rows
        this.columns = columns
        rows.times { rowIndex ->
            board[rowIndex] = 0
            columns.times { colIndex ->
                board[rowIndex][colIndex] = 0
            }

        }
        return board
    }

    def dropBlock() {

        board[0] = 1
        return board
    }

    def lineCollaps() {
        if (board[rows - 1] == 1)
            board[rows - 1] = 0
        return board
    }


    def hasStackUpToTop() {
        if (board[0] == 1)
            return true
        else
            false
    }
}
