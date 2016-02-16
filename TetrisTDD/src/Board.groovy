/**
 * Created by romina on 12.02.2016.
 */
class Board {
    def board = []
    static TetrisBlock fallingBlock = new TetrisBlock()


    def isEmpty() {
        true
    }


    def hasFallingBlocks() {
        if (fallingBlock.isFalling)
            return true
        else
            false
    }

    def dropBlock(TetrisBlock tBlock) {
        fallingBlock = tBlock
        fallingBlock.isFalling = true
        fallingBlock.xPos = 1
        fallingBlock.yPos = board.size() - 1
        board[fallingBlock.xPos][fallingBlock.yPos] = 1
        return board
    }

    def blockIsFalling() {
        fallingBlock.yPos = fallingBlock.yPos - 1
        board[fallingBlock.xPos][fallingBlock.yPos] = 1
        board[fallingBlock.xPos][fallingBlock.yPos + 1] = 0
    }

    def hasArrivedAtBottom() {
        if (fallingBlock.yPos == 0)
            return true
    }


    def hasReachedAnotherBlock() {
        if ((fallingBlock.yPos > 0 && board[0][1] == 1) || (board[1][1] == 1 && fallingBlock.yPos > 1))
            return true
    }

}
