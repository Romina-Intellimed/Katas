/**
 * Created by romina on 17.02.2016.
 */
class TetrisGame {

    public static final int isEmpty = 0
    public static final int isFilled = 1
    TetrisBoard tetrisBoard = new TetrisBoard()
    TetrisBlock fallingBlock
    def countFallingBlocks=0

    def hasOneFallingBlock() {
        if (countFallingBlocks==1)
            return true
        else
            return false
    }

    def blockFallsOneTimeAline() {
            updateBoard(BlockState.IS_FALLING)
    }


    def dropBlock() {
        if(countFallingBlocks<1){
            fallingBlock = new TetrisBlock()
            countFallingBlocks++
            fallingBlock.isFalling = true

            fallingBlock.xPos = 0
            fallingBlock.yPos = 0
            tetrisBoard.addBlock(fallingBlock.xPos, fallingBlock.yPos)

            return tetrisBoard.board
        }
    }

    def hasStackUpToTop() {
        if (tetrisBoard.board[0].get(0) == isFilled)
            return true
        else
            false
    }

    def moveBlockLeft() {
            updateBoard(BlockState.MOVE_LEFT)
    }

    def moveBlockRight() {
            updateBoard(BlockState.MOVE_RIGHT)
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
        if (tetrisBoard.board[1][0] == isFilled && tetrisBoard.board[1][0] == isFilled){
            tetrisBoard.board[1][1] = isEmpty
            tetrisBoard.board[1][0] = isEmpty
        }
    }

    def updateBoard(operation) {
        if (fallingBlock.isFalling) {
            tetrisBoard.removeBlock(fallingBlock.xPos, fallingBlock.yPos)
            switch (operation) {
                case BlockState.IS_FALLING:
                    fallingBlock.xPos = fallingBlock.xPos + 1
                    break
                case BlockState.MOVE_LEFT:
                    fallingBlock.yPos = fallingBlock.yPos + 1
                    break
                case BlockState.MOVE_RIGHT:
                    fallingBlock.yPos = fallingBlock.yPos - 1
                    break
            }
        }
        tetrisBoard.addBlock(fallingBlock.xPos, fallingBlock.yPos)
        return tetrisBoard.board;
    }

}
