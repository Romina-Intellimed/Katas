/**
 * Created by romina on 17.02.2016.
 */
class TetrisGame {

    public static final int isEmpty = 0
    public static final int isFilled = 1
    TetrisBoard tetrisBoard = new TetrisBoard()
    TetrisBlock fallingBlock
    def countFallingBlocks = 0


    def dropBlock() {
        if (countFallingBlocks < 1) {
            fallingBlock = new TetrisBlock()

            fallingBlock.isFalling = true
            countFallingBlocks++

            fallingBlock.xPos = 0
            fallingBlock.yPos = tetrisBoard.board.size() % 2

            tetrisBoard.addBlock(fallingBlock.xPos, fallingBlock.yPos)

            return tetrisBoard.board
        }
    }

    def hasOneFallingBlock() {
        if (countFallingBlocks == 1)
            return true
        else
            return false
    }

    def blockFallsOneTimeAline() {
        updateBoard(BlockState.IS_FALLING)
    }

    def moveBlockLeft() {
        updateBoard(BlockState.MOVE_LEFT)
    }

    def moveBlockRight() {
        updateBoard(BlockState.MOVE_RIGHT)
    }


    def updateBoard(operation) {
        if (fallingBlock.isFalling) {
            tetrisBoard.removeBlock(fallingBlock.xPos, fallingBlock.yPos)
            switch (operation) {
                case BlockState.IS_FALLING:
                    fallingBlock.xPos = fallingBlock.xPos + 1
                    break
                case BlockState.MOVE_LEFT:
                    fallingBlock.yPos = fallingBlock.yPos - 1
                    break
                case BlockState.MOVE_RIGHT:
                    fallingBlock.yPos = fallingBlock.yPos + 1
                    break
            }
        }
        tetrisBoard.addBlock(fallingBlock.xPos, fallingBlock.yPos)
        return tetrisBoard.board;
    }


    def blockHasReachedTheBottom() {
        if (fallingBlock.xPos == (tetrisBoard.board.size() - 1))
            return true
        else
            false
    }


    def blockHasReachedAnotherBlock() {
        if ((fallingBlock.xPos < (tetrisBoard.board.size() - 1)) && (tetrisBoard.board[fallingBlock.xPos + 1][fallingBlock.yPos] == 1)) {
            fallingBlock.isFalling = false
            return true
        } else
            false
    }

    def bottomLineDissapears() {
        tetrisBoard.board.size().times { colIndex ->
            if (tetrisBoard.board[tetrisBoard.board.size() - 1][colIndex] == isFilled)
                tetrisBoard.board[tetrisBoard.board.size() - 1][colIndex] = isEmpty
        }

    }

    def hasStackUpToTop() {
        if (tetrisBoard.board[0].get(1) == isFilled)
            return true
        else
            false
    }


}
