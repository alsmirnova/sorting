package ru.mail.polis.sort;

/**
 * Created by Алена on 21.11.2016.
 */
public class InsertSort {
    public static int[] sort(int[] a) {
        int n = a.length;
        int temp, j, i;
        for (i = 0; i < n; i++) {
            temp = a[i];
            for (j = i; j > 0 && temp < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            if (i != j) {
                a[j] = temp;
            }
        }
        return a;
    }
}

