/**
 * Created by romina on 12.02.2016.
 */
class Board {
    def board = []
    static TetrisBlock fallingBlock = new TetrisBlock()
    def SQUARE_FILLED = 1
    def SQUARE_EMPTY = 0

    def generateEmptyBoard(size) {
        board = [[SQUARE_EMPTY] * size] * size
        return board
    }


    def isEmpty() {
        if (board == [[SQUARE_EMPTY] * board.size()] * board.size())
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
        board[fallingBlock.xPos][fallingBlock.yPos] = SQUARE_FILLED
        return board
    }

    def blockIsFallingOneTimeALine() {
        if (!blockHasReachedAnotherBlock()) {
            fallingBlock.xPos = fallingBlock.xPos + 1
            board = updateBoard(fallingBlock.xPos, fallingBlock.yPos, PieceOperation.IS_FALLING)
        }
    }

    def blockHasArrivedAtBottom() {
        if (fallingBlock.xPos == (board.size() - 1))
            return true
    }


    def blockHasReachedAnotherBlock() {
        if ((fallingBlock.xPos < (board.size() - 1)) && (board[fallingBlock.xPos + 1][fallingBlock.yPos] == SQUARE_FILLED))
            return true
    }

    def blockMovesRight() {
        fallingBlock.yPos = fallingBlock.yPos + 1
        board = updateBoard(fallingBlock.xPos, fallingBlock.yPos, PieceOperation.MOVE_RIGHT)


    }

    def blockMovesLeft() {

        fallingBlock.yPos = fallingBlock.yPos - 1
        board = updateBoard(fallingBlock.xPos, fallingBlock.yPos, PieceOperation.MOVE_LEFT)

    }

    def lineCollaps() {

        board.eachWithIndex { line, index ->
            if (line == [SQUARE_FILLED] * board.size())
                board[index] = [SQUARE_EMPTY] * board.size()
        }
    }

    def updateBoard(xPos, yPos, operation) {
        switch (operation) {
            case PieceOperation.IS_FALLING:
                board[xPos - 1][yPos] = SQUARE_EMPTY
                break
            case PieceOperation.MOVE_LEFT:
                board[xPos][yPos + 1] = SQUARE_EMPTY
                break
            case PieceOperation.MOVE_RIGHT:
                board[xPos][yPos - 1] = SQUARE_EMPTY
                break
        }

        board[xPos][yPos] = SQUARE_FILLED

        return board;
    }


}
