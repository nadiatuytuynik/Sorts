package com.netcracker.sorts;

/**
 * The class is used for sorting by the BubbleSortToMax algorithm.
 *
 * @author Tiutiunyk
 * @version 1.0
 */

public class BubbleSortToMax extends Sort {

    /**
     * The ascending sort method uses the method
     *
     * @see Sort#swap
     */
    @Override
    public void sort(int[] a) {
        for (int j = 0; j < a.length - 1; j++) {
            for (int i = 0; i < (a.length - 1); i++) {
                if (a[i] > a[i + 1]) {
                    a[i + 1] = swap(a[i], a[i] = a[i + 1]);
                }
            }
        }
    }
}
