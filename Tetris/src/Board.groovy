/**
 * Created by romina on 17.02.2016.
 */
class Board {

    def board = []
    def size

    def isEmpty() {

        return board.isEmpty()
    }


    def emptyTheBoard(board) {
        board.size().times { rowIndex ->
            board.size().times { colIndex ->
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
        if (board[board.size() - 1] == 1)
            board[board.size() - 1] = 0
    }


    def hasStackUpToTop() {
        if (board[0] == 1)
            return true
        else
            false
    }
}
