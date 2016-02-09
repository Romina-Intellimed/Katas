/**
 * Created by romina on 09.02.2016.
 */
class Cell {

    def state = 0;
    def liveNeighbours;


    def getLiveNeighbours() {
        liveNeighbours = 0
        return liveNeighbours
    }

    def updateCellState(){
        if (liveNeighbours == 0){
            state=1
        }
    }

    def getState() {
        return state
    }
}
