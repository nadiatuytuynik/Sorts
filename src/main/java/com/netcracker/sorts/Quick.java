package com.netcracker.sorts;

/**
 * The main class for implementing inheritance of two algorithms for sorting the BubbleSortToMin
 *
 * @author Tiutiunyk
 * @version 1.0
 */
public class Quick {

    /**
     * Sorting method using the fast sort algorithm (position setting)
     * use method @see Quick#doSort
     *
     * @param arr - unsorted array
     * @return Returns the sorted array
     */
    public static int[] quickSort(int[] arr) {
        int[] res = null;
        int startIndex = 0;
        int endIndex = arr.length - 1;
        doSort(startIndex, endIndex, arr);
        return arr;
    }

    /**
     * Sorting method using the fast sort algorithm (sorting with new positions)
     * use method @see Quick#doSort
     *
     * @param end   - end position of sorting
     * @param start - start position of sorting
     * @return arr - unsorted array
     */
    private static void doSort(int start, int end, int[] arr) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (arr[i] <= arr[cur])) {
                i++;
            }
            while (j > cur && (arr[cur] <= arr[j])) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur, arr);
        doSort(cur + 1, end, arr);
    }

}
