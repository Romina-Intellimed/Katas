/**
 * Created by romina on 03.02.2016.
 */
class Cell {

    def state
    static int alive = 1
    static int dead = 0
    def cellXPos
    def cellYPos
    def aliveState
    def type


    Cell(int aliveState) {
        this.aliveState = aliveState
    }

    boolean isTopLeftCornerCell() {
        (cellXPos - 1) < 0 && (cellYPos - 1) < 0
    }

    boolean isTopMiddleEdgeCell() {
        def xPreviousPos = cellXPos - 1
        xPreviousPos < 0
    }

    String toString() {
        state ? "true" : "false"
    }

    def beAlive() {
        this.aliveState = Cell.alive
    }

    def beDead() {
        this.aliveState = Cell.dead
    }

}
