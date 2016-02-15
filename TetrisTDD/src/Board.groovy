/**
 * Created by romina on 12.02.2016.
 */
class Board {
    def board = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
    static TetrisBlock fallingBlock =new TetrisBlock()


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
        fallingBlock.xPos=0
        fallingBlock.yPos=board.size()
        board[0][1] = 1
        return board
    }

    def blockIsFalling() {
        fallingBlock.yPos = fallingBlock.yPos -1

    }

    def hasArrivedAtBottom(){
        if(fallingBlock.yPos==0)
            return true
        else
            false
    }

}
