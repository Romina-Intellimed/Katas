/**
 * Created by romina on 17.02.2016.
 */
class TetrisGame {

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
            columns.times { colIndex ->
                board[rowIndex][colIndex] = 0
            }

        }
        return board
    }

    def dropBlock() {

        board[0].add(1)
        return board
    }

    def hasStackUpToTop() {
        if (board[0].get(0) == 1)
            return true
        else
            false
    }
}
