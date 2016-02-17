/**
 * Created by romina on 17.02.2016.
 */
class Board {

    def board=[]

    def isEmpty(){
       return board.isEmpty()
    }

    def generateEmptyBoard(size){
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
}
