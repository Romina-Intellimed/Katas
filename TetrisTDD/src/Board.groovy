/**
 * Created by romina on 12.02.2016.
 */
class Board {

    def board = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]

    def isEmpty() {
        true
    }


    def hasFallingBlocks() {
        if (board[0][1] == 1 || board[1][1] == 1)
            return true
        else
            false
    }

    def dropBlock() {
        board[0][1] = 1
        return board
    }

    def blockIsFalling() {

        board[1][1] = 1
        return board
    }


}
