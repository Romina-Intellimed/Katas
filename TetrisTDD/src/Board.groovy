/**
 * Created by romina on 12.02.2016.
 */
class Board {
    int countFallingLines = 0
    def board = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]

    def isEmpty() {
        true
    }


    def hasFallingBlocks() {
        if (board[0][1] == 1 || countFallingLines!=0)
            return true
        else
            false
    }

    def dropBlock() {
        board[0][1] = 1
        return board
    }

    def blockIsFalling() {

       countFallingLines++
    }

    def hasArrivedAtBottom(){
        if(countFallingLines==board.size())
            return true
        else
            false
    }

}
