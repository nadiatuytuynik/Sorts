package com.netcracker.analytics;

import com.netcracker.arrays.MyArrays;
import com.netcracker.sorts.BubbleSortToMax;
import com.netcracker.sorts.BubbleSortToMin;
import com.netcracker.sorts.Merge;
import com.netcracker.sorts.Quick;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * The class for automatic data collection about the working time of all sorting algorithms
 *
 * @author Tiutiunyk
 * @version 1.0
 */
public class Analytics {
    /**
     * The method for automatic data collection about the working time of all sorting algorithms
     *
     * @param len - end position of sorting
     * @param max - start position of sorting
     * @param min - checked array
     * <p>
     * use method for generating arrays
     * @return timeResult - array with run-time values in nano seconds
     * @see BubbleSortToMin#sort
     * @see BubbleSortToMin#sort
     * @see Merge#mergeSort
     * @see Quick#quickSort
     * <p>
     * with all types of sgenirovannyh
     * @see MyArrays#sortedArray
     * @see MyArrays#unsortedArray
     * @see MyArrays#randomArray
     * @see MyArrays#sortedArrayWithRandom
     * @see Analytics#reflectionArray
     * <p>
     * use methods for generating sorts
     * @see Analytics#reflectionBubbleSortToMax
     * @see Analytics#reflectionBubbleSortToMin
     * {@link Analytics#reflectionMerge}
     * {@link Analytics#reflectionQuick(Class, Quick, int[], ArrayList)}
     * {@link Analytics#timeCalc(Method, int[], Object, ArrayList)}
     **/
    public static ArrayList<Long> reflection(int len, int max, int min) throws Exception {
        ArrayList<Long> timeResult = new ArrayList<Long>();
        Class arrays = Class.forName("com.netcracker.arrays.MyArrays");
        MyArrays ar = (MyArrays) arrays.newInstance();
        int[] sortedarr = reflectionArray(arrays, ar, "sortedArray", len, max, min);
        int[] unsortedarr = reflectionArray(arrays, ar, "unsortedArray", len, max, min);
        int[] randomarray = reflectionArray(arrays, ar, "randomArray", len, max, min);
        int[] sortedarraywithrandom = reflectionArray(arrays, ar, "sortedArrayWithRandom", len, max, min);

        int[] arr = null;
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    arr = sortedarr;
                case 1:
                    arr = unsortedarr;
                case 2:
                    arr = randomarray;
                case 3:
                    arr = sortedarraywithrandom;
            }

            Class quick = Class.forName("com.netcracker.sorts.Quick");
            Quick qk = (Quick) quick.newInstance();
            reflectionQuick(quick, qk, arr, timeResult);

            Class merge = Class.forName("com.netcracker.sorts.Merge");
            Merge mr = (Merge) merge.newInstance();
            reflectionMerge(merge, mr, arr, timeResult);

            Class bubble2 = Class.forName("com.netcracker.sorts.BubbleSortToMax");
            BubbleSortToMax b2 = (BubbleSortToMax) bubble2.newInstance();
            reflectionBubbleSortToMax(bubble2, b2, arr, timeResult);

            Class bubble1 = Class.forName("com.netcracker.sorts.BubbleSortToMin");
            BubbleSortToMin b1 = (BubbleSortToMin) bubble1.newInstance();
            reflectionBubbleSortToMin(bubble1, b1, arr, timeResult);

        }
        return timeResult;
    }


    /**
     * The method for automatic start of class methods using reflexion
     *
     * @see BubbleSortToMin#sort(int[])
     * @see BubbleSortToMin#sort(int[])
     * use method for calculating of metod's time running
     * @see Analytics#timeCalc(Method, int[], Object, ArrayList)
     **/
    private static void reflectionBubbleSortToMin(Class clas, BubbleSortToMin bl, int[] arr, ArrayList<Long> timeResult) throws Exception {
        Method method1 = clas.getMethod("sort", int[].class);
        timeCalc(method1, arr, bl, timeResult);
    }

    private static void reflectionBubbleSortToMax(Class clas, BubbleSortToMax b2, int[] arr, ArrayList<Long> timeResult) throws Exception {
        Method method1 = clas.getMethod("sort", int[].class);
        timeCalc(method1, arr, b2, timeResult);
    }

    /**
     * The method for automatic start of class methods using reflexion
     *
     * @see Merge#mergeSort(int[])
     * use method for calculating of metod's time running
     * @see Analytics#timeCalc(Method, int[], Object, ArrayList)
     **/
    private static void reflectionMerge(Class clas, Merge mr, int[] arr, ArrayList<Long> timeResult) throws Exception {
        Method method1 = clas.getMethod("mergeSort", int[].class);
        timeCalc(method1, arr, mr, timeResult);
    }

    /**
     * The method for automatic start of class methods using reflexion
     *
     * @see Quick#quickSort(int[])
     * use method for calculating of metod's time running
     * @see Analytics#timeCalc(Method, int[], Object, ArrayList)
     **/
    private static void reflectionQuick(Class clas, Quick qk, int[] arr, ArrayList<Long> timeResult) throws Exception {
        Method method1 = clas.getMethod("quickSort", int[].class);
        timeCalc(method1, arr, qk, timeResult);
    }

    /**
     * The method for calculating of metod's time running
     *
     * @param method     - test method
     * @param arr        - working array
     * @param obj        - object (class)
     * @param timeResult - array of time results
     **/
    private static void timeCalc(Method method, int[] arr, Object obj, ArrayList<Long> timeResult) throws Exception {
        try {
            long timeStart = System.nanoTime();
            Object result = method.invoke(obj, arr);
            long timeFinish = System.nanoTime();
            long time = timeFinish - timeStart;
            timeResult.add(time);
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException");
        }
    }

    /**
     * The method for generating working arrays
     *
     * @param clas        - working class
     * @param ar          - type of working array
     * @param nameOfArray - name of working array
     * @param len         - length of array
     * @param max         - maximum element of array
     * @param min         - minimum element of array
     * @return result - array of time-running results
     **/
    private static int[] reflectionArray(Class clas, MyArrays ar, String nameOfArray, int len, int max, int min) throws Exception {
        Method method1 = clas.getMethod(nameOfArray, int.class, int.class, int.class);
        int[] result = (int[]) method1.invoke(ar, len, max, min);
        return result;
    }
}

