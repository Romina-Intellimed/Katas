/**
 * Created by romina on 17.02.2016.
 */
class Board {

    def board=[]
    def size
    def isEmpty(){
       return board.isEmpty()
    }

    static Board aBoard(){
        new Board(size:1)
    }

    def generateEmptyBoard(){
        board = [0*size]*size
        return board
    }

    def dropBlock(){
        board[0]=1
        return board
    }

    def lineCollaps(){
        if(board[board.size()-1]==1)
            board[board.size()-1]=0
    }


    def hasStackUpToTop(){
        if(board[0]==1)
            return true
        else
            false
    }
}
