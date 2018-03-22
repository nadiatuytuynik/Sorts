package com.netcracker.sorts;

import java.util.Arrays;

/**
 * The class is used for sorting by the Merger algorithm.
 *
 * @author Tiutiunyk
 * @version 1.0
 */

public class Merge {

    /**
     * The merge algorithm method uses an additional method for intermediate mergers
     *
     * @param arr- unsorted array
     * @return Returns the sorted array
     * @see Merge#merge
     **/

    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;
        int m = arr.length / 2;
        int[] arr1 = Arrays.copyOfRange(arr, 0, m);
        int[] arr2 = Arrays.copyOfRange(arr, m, arr.length);
        return merge(mergeSort(arr1), mergeSort(arr2));
    }

    /**
     * The method of merging two arrays into one sorted
     *
     * @param arr1 - first array
     * @param arr2 - second array
     * @return arr - returns a sorted array - the result of merging two arrays
     **/
    public static int[] merge(int[] arr1, int arr2[]) {
        int n = arr1.length + arr2.length;
        int[] arr = new int[n];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < n; i++) {
            if (i1 == arr1.length) {
                arr[i] = arr2[i2++];
            } else if (i2 == arr2.length) {
                arr[i] = arr1[i1++];
            } else {
                if (arr1[i1] < arr2[i2]) {
                    arr[i] = arr1[i1++];
                } else {
                    arr[i] = arr2[i2++];
                }
            }
        }
        return arr;
    }

}
