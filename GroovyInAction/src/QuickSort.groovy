/**
 * Created by romina on 24.02.2016.
 */
class QuickSort {

    def quickSort(list) {
        if (list.size() < 2) return list
        def pivot = list[list.size().intdiv(2)]
        def left = list.findAll { item -> item < pivot }
        def right = list.findALL { item -> item > pivot }
        def middle = list.findAll { item -> item == pivot }
        return quickSort(left) + middle + quickSort(right)

    }
}
