package ru.mail.polis.sort;

/**
 * Created by Алена on 21.11.2016.
 */
public class MergeSort {
    public static int[] sort(int[] a) {
        int n = a.length;
        int t[] = new int[n];
        for (int i = 1; i < n; i *= 2) {
            for (int j = 0; j < n - i; j += 2 * i) {
                MergeSort.merge(a, t, j, j + i - 1, MergeSort.min(j + 2 * i - 1, n - 1));
            }
        }

        return a;
    }

    public static void merge(int[] a, int[] t, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            t[i] = a[i];
        }
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                a[k] = t[j++];
            } else if (j > right) {
                a[k] = t[i++];
            } else if (t[j] < t[i]) {
                a[k] = t[j++];
            } else {
                a[k] = t[i++];
            }
        }
    }

    public static int min(int a, int b) {
        if (b - a < 0) return b;
        else return a;
    }
}
