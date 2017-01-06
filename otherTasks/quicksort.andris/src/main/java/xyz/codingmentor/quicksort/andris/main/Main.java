package xyz.codingmentor.quicksort.andris.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.quicksort.andris.sort.QuickSort;

/**
 *
 * @author brianelete
 */
public class Main {

    private Main() {
        //hide the implicit public constructor
    }
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList();
        Random rnd = new Random();
        for (int i = 0; i < rnd.nextInt(100); i++) {
            numbers.add(rnd.nextInt(100));
        }

        QuickSort<Integer> quicksort = new QuickSort<>();
        LOGGER.log(Level.INFO, numbers.toString());
        quicksort.qsort(numbers, 0, numbers.size() - 1);
        LOGGER.log(Level.INFO, numbers.toString());
    }
}
