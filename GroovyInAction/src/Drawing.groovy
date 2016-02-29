/**
 * Created by romina on 29.02.2016.
 */
class Drawing {

    List shapes

    def accept(Closure yield) { shapes.each { it.accept(yield) } }


}





