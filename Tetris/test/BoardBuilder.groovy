/**
 * Created by romina on 18.02.2016.
 */
class BoardBuilder {
    def lines
    def columns



    static BoardBuilder aBoard() {
        new BoardBuilder(lines: 1, columns:0)
    }

    def withSize(lines,columns) {
        this.lines = lines
        this.columns=columns
        this
    }

    def buildBoard() {
        def board = []
        lines.times { rowIndex ->
            board[rowIndex] = []
            columns.times { colIndex ->
                board[rowIndex][colIndex]=0
            }

        }
        return board
    }


}
