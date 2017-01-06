package xyz.codingmentor.quicksort.andris.sort;

import java.util.List;

/**
 *
 * @author brianelete
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> {

    public void qsort(List<T> values, int low, int high) {
        if (low < high) {
            int i = low, j = high;
            T pivot = values.get((i + j) / 2);

            do {
                while (values.get(i).compareTo(pivot) < 0) {
                    i++;
                }
                while (pivot.compareTo(values.get(j)) < 0) {
                    j--;
                }

                if (i <= j) {
                    T tmp = values.get(i);
                    values.add(i, values.get(j));
                    values.remove(i + 1);
                    values.add(j, tmp);
                    values.remove(j + 1);
                    i++;
                    j--;
                }

            } while (i <= j);

            qsort(values, low, j);
            qsort(values, i, high);
        }
    }

}
