package com.netcracker.arrays;

import com.netcracker.sorts.BubbleSortToMax;
import com.netcracker.sorts.BubbleSortToMin;

/**
 * Class for generating arrays of specified length, maximum and minimum number
 *
 * @author Tiutiunyk
 * @version 1.0
 */
public class MyArrays {

    private static BubbleSortToMax bubbleSortToMax = new BubbleSortToMax();
    private static BubbleSortToMin bubbleSortToMin = new BubbleSortToMin();

    /**
     * The method for generating a sorted array
     *
     * @param len - length of array
     * @param max - the maximum element of the array
     * @param min - the minimum element of the array
     * @return arr - generated sorted array
     */
    public static int[] sortedArray(int len, int max, int min) {
        int[] arr = new int[len];
        max -= min;
        int k;
        for (int i = 0; i < len; i++) {
            k = (int) (Math.random() * ++max) + min;
            arr[i] = k;
        }
        bubbleSortToMax.sort(arr);
        return arr;
    }

    /**
     * The method for generating a unsorted array
     *
     * @param len - length of array
     * @param max - the maximum element of the array
     * @param min - the minimum element of the array
     * @return arr - generated unsorted array
     */
    public static int[] unsortedArray(int len, int max, int min) {
        int[] arr = new int[len];
        max -= min;
        int k;
        for (int i = 0; i < len; i++) {
            k = (int) (Math.random() * ++max) + min;
            arr[i] = k;
        }
        bubbleSortToMin.sort(arr);
        return arr;
    }

    /**
     * The method for generating a random array
     *
     * @param len - length of array
     * @param max - the maximum element of the array
     * @param min - the minimum element of the array
     * @return arr - generated random array (with random numbers)
     */
    public static int[] randomArray(int len, int max, int min) {
        int[] arr = new int[len];
        max -= min;
        int k;
        for (int i = 0; i < len; i++) {
            k = (int) (Math.random() * ++max) + min;
            arr[i] = k;
        }
        return arr;
    }

    /**
     * The method for generating a sorted array with one random number at the end
     *
     * @param len - length of array
     * @param max - the maximum element of the array
     * @param min - the minimum element of the array
     * @return arr - generated sorted array with one random number at the end
     */
    public static int[] sortedArrayWithRandom(int len, int max, int min) {
        int[] arr = new int[len];
        max -= min;
        int k;
        for (int i = 0; i < len; i++) {
            k = (int) (Math.random() * ++max) + min;
            arr[i] = k;
        }
        bubbleSortToMax.sort(arr);
        arr[len - 1] = (int) (Math.random() * ++max) + min;
        return arr;
    }
}
