import com.sun.org.apache.xpath.internal.operations.Bool

/**
 * Created by romina on 03.02.2016.
 */
class GameOfLifeCell {

    def state

    GameOfLifeCell(Boolean state){
        this.state = state
    }

    String toString() {
        state? "true" : "false"
    }
}
