/**
 * Created by romina on 27.02.2016.
 */
class MultiMethodSample {

    int mysteryMethod(String value) {
        return value.length()
    }

    int mysteryMethod(List list) {
        return list.size()
    }

    int mysteryMethod(int x, int y) {
        return x + y
    }




}
