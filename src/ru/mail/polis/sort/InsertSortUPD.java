package ru.mail.polis.sort;

import java.util.Arrays;

/**
 * Created by Алена on 25.11.2016.
 */
public class InsertSortUPD {
    public static int[] aa;
    public static int[] sort(int[] a) {
        int n = a.length;
        int k, j, i;
        for (i = 1; i < n; i++) {
            j = i - 1;
            k = binSearch(a, a[i], 0, j);
            shift(a, i, k);
        }

        return a;
    }

    private static void shift(int[] a, int val, int k) {
        aa = Arrays.copyOfRange(a, k + 1, val);
        a[k + 1] = a[val]; //length=val-k+1;
        for (int i = 0; i < aa.length; i++) {
            a[k + 2 + i] = aa[i];
        }
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int binSearch(int[] a, int key, int left, int right) {
        int m;
        int l = left - 1;
        int r = right + 1;
        while (l < r - 1) {
            m = (l + r) / 2;
            if (a[m] <= key) l = m;
            else r = m;
        }

        return l;
    }

}

