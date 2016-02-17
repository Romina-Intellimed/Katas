/**
 * Created by romina on 12.02.2016.
 */
class Board {
    def board = []
    TetrisBlock fallingBlock = new TetrisBlock()

    def generateEmptyBoard(size) {
        board = [[BoardSquare.EMPTY] * size] * size
        return board
    }

    def isEmpty() {
        if (board == [[BoardSquare.EMPTY] * board.size()] * board.size())
            true
        else
            false
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
        board[fallingBlock.xPos][fallingBlock.yPos] = BoardSquare.FILLED
        return board
    }

    def blockIsFallingOneTimeALine() {
        if (!blockHasReachedAnotherBlock()) {
            fallingBlock.xPos = fallingBlock.xPos + 1
            board = updateBoard(fallingBlock.xPos, fallingBlock.yPos, PieceOperation.IS_FALLING)

        }
        return board
    }

    def blockHasArrivedAtBottom() {
        if (fallingBlock.xPos == (board.size() -1))
            return true
        else
            false
    }

    def blockHasReachedAnotherBlock() {
        if ((fallingBlock.xPos < (board.size() - 1)) && (board[fallingBlock.xPos + 1][fallingBlock.yPos] == BoardSquare.FILLED))
            return true
        else
            false
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
            if (line == BoardSquare.FILLED * board.size())
                board[index] = [BoardSquare.EMPTY] * board.size()
        }
    }

    def updateBoard(xPos, yPos, operation) {
        board[xPos][yPos] = BoardSquare.FILLED
        switch (operation) {
            case PieceOperation.IS_FALLING:
                board[xPos - 1][yPos] = BoardSquare.EMPTY
                break
            case PieceOperation.MOVE_LEFT:
                board[xPos][yPos + 1] = BoardSquare.EMPTY
                break
            case PieceOperation.MOVE_RIGHT:
                board[xPos][yPos - 1] = BoardSquare.EMPTY
                break
        }


        return board;
    }


}
