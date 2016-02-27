/**
 * Created by romina on 27.02.2016.
 */
class SizeFilter {
    Integer limit

    boolean sizeUpTo(String value) {
        return value.size() <= limit
    }
}
