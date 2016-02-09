import spock.lang.Specification

/**
 * Created by romina on 09.02.2016.
 */
class CellSpec extends Specification {

    Cell cell;

    void setup() {
        cell = new Cell()
    }


    void "one live cell with no live neighbour will die "() {
        given:
        cell.state = 0
        cell.liveNeighbours = 0
        when:
        cell.updateCellState()
        then:
        cell.state == 1
    }

    void "one live cell with one live neighbours will die "() {
        given:
        cell.state = 0
        cell.liveNeighbours = 1
        when:
        cell.updateCellState()
        then:
        cell.state == 1
    }

    void "one live cell with 2 live neigbours will live"() {
        given:
        cell.state = 0
        cell.liveNeighbours = 2
        when:
        cell.updateCellState()
        then:
        cell.state == 0
    }

    void "one live cell with 3 live neighbours will live"() {
        given:
        cell.state = 0
        cell.liveNeighbours = 3
        when:
        cell.updateCellState()
        then:
        cell.state == 0
    }


    void "one live cell with 4 live neighbours will die"() {

    }

    void "one live cell with more than 3 live neighbours will die"() {

    }


    void "one dead cell with one live neigbours will be dead"() {

    }

    void "one dead cell with two live neigbours will be dead"() {

    }

    void "one dead cell with three live neigbours will live"() {

    }


    void "one dead cell with four live neigbours will be dead"() {

    }

    void "one dead cell with more than four live neigbours will be dead"() {

    }
}
