package ru.mail.polis.sort;

/**
 * Created by Алена on 22.11.2016.
 */
public class QuickSortFix {

    public static int[] sort(int[] a) {
        qsort(a, 0, a.length - 1);
        return a;
    }

    public static void qsort(int[] array, int left, int right) {
        if (left<right) {
            int index = partition(array, left, right);
            qsort(array, left, index - 1);
            qsort(array, index + 1, right);
        }
    }

    public static int partition(int[] array, int left, int right) {
        int index = (left + right) / 2;
        int pivot = array[index];
        swap(array, index, right);
        for (int i = index = left; i < right; ++i) {
            if (array[i] <= pivot) {
                swap(array, index++, i);
            }
        }
        swap(array, index, right);
        return (index);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
