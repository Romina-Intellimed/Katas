/**
 * Created by romina on 17.02.2016.
 */
class TetrisGame {

    TetrisBoard tetrisBoard=new TetrisBoard()

    def board = []



    def hasOneFallingBlock(){
        if(dropBlock())
            return true
        else
            return false
    }

    def dropBlock() {
        tetrisBoard.addBlock(0,1)
        return tetrisBoard.board
    }

    def hasStackUpToTop() {
        if (tetrisBoard.board[0].get(1) == 1)
            return true
        else
            false
    }




}