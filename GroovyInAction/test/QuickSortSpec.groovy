import spock.lang.Specification

/**
 * Created by romina on 24.02.2016.
 */
class QuickSortSpec extends Specification {

    def quickSort

    void setup() {
        quickSort = new QuickSort()

    }


    void "test quick sort algorithm"() {

        expect:
        assert quickSort.sort([]) == []
        assert quickSort.sort([1]) == [1]
        assert quickSort.sort([1, 2]) == [1, 2]
        assert quickSort.sort([2, 1]) == [1, 2]
        assert quickSort.sort([3, 1, 2]) == [1, 2, 3]
        assert quickSort.sort([3, 1, 2, 2]) == [1, 2, 2, 3]
        assert quickSort.sort([1.0f, 'a', 10, null]) == [null, 1.0f, 10, 'a']
        assert quickSort.sort('bca') == 'abc'.toList()

    }

}
