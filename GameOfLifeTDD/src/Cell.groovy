/**
 * Created by romina on 09.02.2016.
 */
class Cell {

    def state = 0;
    def liveNeighbours;



    def updateCellState() {
        if (liveNeighbours < 2) {
            state = 1
        }
        if (liveNeighbours == 2) {
            state = 0
        }
    }

    def getState() {
        return state
    }
}
