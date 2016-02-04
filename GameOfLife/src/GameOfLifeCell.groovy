import com.sun.org.apache.xpath.internal.operations.Bool

/**
 * Created by romina on 03.02.2016.
 */
class GameOfLifeCell {

    def state
    def aliveNeighbours
    static int alive = 1
    static int dead = 0
    def cellXPos
    def cellYPos
    def aliveState

    GameOfLifeCell(){

    }

    GameOfLifeCell(Boolean state){
        this.state = state
    }

    GameOfLifeCell(int aliveState) {
        this.aliveState = aliveState
    }

    String toString() {
        state? "true" : "false"
    }

    def beAlive(){
        this.aliveState = GameOfLifeCell.alive
    }

    def beDead() {
        this.aliveState = GameOfLifeCell.dead
    }
}
