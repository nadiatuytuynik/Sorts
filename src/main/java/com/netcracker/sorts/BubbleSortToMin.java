package com.netcracker.sorts;

/**
 * The class is used for sorting by the BubbleSortToMin algorithm.
 *
 * @author Tiutiunyk
 * @version 1.0
 */

public class BubbleSortToMin extends Sort {

    public BubbleSortToMin() {
    }
    /**
     * The method of sorting in descending order uses the method
     *
     * @see Sort#swap
     */
    @Override
    public void sort(int[] a) {
        for (int j = 0; j < a.length - 1; j++) {
            for (int i = a.length - 1; i > 0; i--) {
                if (a[i] > a[i - 1]) {
                    a[i - 1] = swap(a[i], a[i] = a[i - 1]);
                }
            }
        }
    }
}