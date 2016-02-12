import spock.lang.Ignore
import spock.lang.Specification

/**
 * Created by romina on 11.02.2016.
 */
class GameSpec extends Specification{

    def "empty universe evolves into empty universe"(){
        given:
        def universe = new Universe()

        when:
        def evolvedUniverse = universe.evolve()

        then:
        evolvedUniverse.isEmpty()
    }

    // Strict collaboration test using mock: universe.evolve() calls cell.evolve() only once
    def "universe with a cell delegates evolution to cell"(){
        given:
        def cellMock = Mock(Cell)
        def universe = new Universe()
        universe.add(cellMock)

        when:
        universe.evolve()

        then:
        1 * cellMock.evolve()
    }

    // Isolated state test using stub: assuming cell.evolve() returns the right thing, universe.evolve() returns the right thing
    def "universe with a cell returns universe with evolved cell"(){
        given:
        def evolvedCell = new Cell()

        def cellStub = Mock(Cell){
            // when calling cell.evolve() return evolvedCell
            evolve() >> evolvedCell
        }

        def universe = new Universe()
        universe.add(cellStub)


        when:
        def evolvedUniverse = universe.evolve()

        then:
        evolvedUniverse.cell == evolvedCell
    }


    // Naive Combined test - doesn't work due to spock limitations
    @Ignore
    def "universe with a cell evolves into universe with evolved cell try 1"(){
        given:
        def evolvedCell = new Cell()
        def cell = Mock(Cell){
            evolve() >> evolvedCell
        }

        def universe = new Universe()
        universe.add(cell)

        when:
        def evolvedUniverse = universe.evolve()

        then:
        1 * cell.evolve()
        evolvedUniverse.cell == evolvedCell
    }

    // Combined test
    def "universe with a cell evolves into universe with evolved cell"(){
        given:
        def evolvedCell = new Cell()
        def cellMock = Mock(Cell){
            1 * evolve() >> evolvedCell
        }

        def universe = new Universe()
        universe.add(cellMock)

        when:
        def evolvedUniverse = universe.evolve()

        then:
        evolvedUniverse.cell == evolvedCell
    }

    def "saves universe state"(){
        given:
        def universe = new Universe()
        def cell = new Cell()
        universe.add(cell)
        def writer = Mock(UniverseWriter)

        when:
        universe.save(writer)

        then:
        // Less strict verification per parameter: write anything
        // 1 * writer.write(_)

        // Strict verification: write exactly once exactly the right cell
        1 * writer.write(cell)

        // Less strict verification for first parameter:
        // 1 * writer.write(_, cell)

        // Least strict verification - any parameters:
        // 1 * writer.write(*_)

        // Same with stubs: no matter how you call the method, get something
        // writer.write(*_) >> something

    }

}
