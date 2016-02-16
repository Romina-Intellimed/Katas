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
        fallingBlock.xPos = 0
        fallingBlock.yPos = 1
        board[fallingBlock.xPos][fallingBlock.yPos] = 1
        return board
    }

    def blockIsFallingOneTimeALine() {
        if (!blockHasReachedAnotherBlock()) {
            fallingBlock.xPos = fallingBlock.xPos + 1
            board[fallingBlock.xPos][fallingBlock.yPos] = 1
            board[fallingBlock.xPos - 1][fallingBlock.yPos] = 0
        }
    }
    def blockHasArrivedAtBottom() {
        if (fallingBlock.xPos == (board.size() - 1))
            return true
    }


    def blockHasReachedAnotherBlock() {
        if ((fallingBlock.xPos < (board.size() - 1) && board[fallingBlock.xPos + 1][fallingBlock.yPos] == 1))
            return true
    }

    def blockMovesRight() {
        fallingBlock.yPos = fallingBlock.yPos + 1
        board[fallingBlock.xPos][fallingBlock.yPos] = 1
        board[fallingBlock.xPos][fallingBlock.yPos - 1] = 0
    }

    def blockMovesLeft() {

            fallingBlock.yPos = fallingBlock.yPos - 1
            board[fallingBlock.xPos][fallingBlock.yPos] = 1
            board[fallingBlock.xPos][fallingBlock.yPos + 1] = 0

    }

    def lineCollaps() {

        board.eachWithIndex { line, index ->
            if (line == [1, 1, 1])
                board[index] = [0, 0, 0]
        }
    }


}
