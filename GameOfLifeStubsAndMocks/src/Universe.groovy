/**
 * Created by romina on 11.02.2016.
 */
class Universe {
    def cell

    def evolve() {
        if(cell == null) {
            return new Universe()
        } else {
            return new Universe(cell: cell.evolve())

            // Equivalent with
//            def evolvedUniverse = new Universe()
//            evolvedUniverse.cell = cell.evolve()
//            return evolvedUniverse

        }
    }

    def isEmpty(){
        return true
    }

    def add(cell) {
        this.cell = cell
    }

    def save(def universeWriter) {
        universeWriter.write(cell)
    }
}
