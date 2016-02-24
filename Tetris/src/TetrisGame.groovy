/**
 * Created by romina on 17.02.2016.
 */
class TetrisGame {

    TetrisBoard tetrisBoard = new TetrisBoard()
    TetrisBlock fallingBlock

    def hasOneFallingBlock() {
        if (dropBlock())
            return true
        else
            return false
    }

    def blockFallsOneTimeAline() {
        if (fallingBlock.isFalling) {
            tetrisBoard.removeBlock(fallingBlock.xPos, fallingBlock.yPos)
            fallingBlock.xPos = fallingBlock.xPos + 1
            tetrisBoard.addBlock(fallingBlock.xPos, fallingBlock.yPos)
        }
    }


    def dropBlock() {
        fallingBlock = new TetrisBlock()

        fallingBlock.isFalling = true

        fallingBlock.xPos = 0
        fallingBlock.yPos = 0
        tetrisBoard.addBlock(fallingBlock.xPos, fallingBlock.yPos)

        return tetrisBoard.board
    }

    def hasStackUpToTop() {
        if (tetrisBoard.board[0].get(0) == 1)
            return true
        else
            false
    }

    def moveBlockLeft(){
        if (fallingBlock.isFalling) {
            tetrisBoard.removeBlock(fallingBlock.xPos, fallingBlock.yPos)
            fallingBlock.yPos = fallingBlock.yPos + 1
            tetrisBoard.addBlock(fallingBlock.xPos, fallingBlock.yPos)
        }
    }

    def moveBlockRight(){
        if (fallingBlock.isFalling) {
            tetrisBoard.removeBlock(fallingBlock.xPos, fallingBlock.yPos)
            fallingBlock.yPos = fallingBlock.yPos - 1
            tetrisBoard.addBlock(fallingBlock.xPos, fallingBlock.yPos)
        }
    }


    def updateBoard(){

    }


}
