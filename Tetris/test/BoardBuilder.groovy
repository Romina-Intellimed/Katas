/**
 * Created by romina on 18.02.2016.
 */
class BoardBuilder {

    def size


    static BoardBuilder aBoard() {
        new BoardBuilder(size: 1)
    }

    def withSize(size) {
        this.size = size
        this
    }

    def buildBoard() {
        def board = []
        size.times { rowIndex ->
            board[rowIndex]=[]
            size.times { colIndex ->
                board[rowIndex][colIndex]=0
            }

        }
        return board
    }


}
