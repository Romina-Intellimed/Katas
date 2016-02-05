import com.sun.org.apache.xpath.internal.operations.Bool

/**
 * Created by romina on 03.02.2016.
 */
class GameOfLifeCell {

    def state
    static int alive = 1
    static int dead = 0
    def cellXPos
    def cellYPos
    def aliveState
    def type


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
