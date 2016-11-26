package ru.mail.polis.sort;

import java.util.Random;

/**
 * Created by Алена on 26.11.2016.
 */
public class KStatistics {
    public static final Random RND = new Random();

    public static int findOrderStatistic(int[] a, int k) {
        int left = 0;
        int mid;
        int right = a.length - 1;
        while (true) {
            mid = partition(a, left, right);
            if (k==mid) return a[mid];
            else if (k < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

    }

    private static int partition(int[] array, int left, int right) {
        int index = (left+right)/2;
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

    public static void main(String[] args) {
        int[] a = {4, 3, 2, 1};
        int k=0;
        for (int i=0; i<a.length;i++) {

            System.out.println("K= " + k +": " +findOrderStatistic(a, k));
            k++;
        }
    }


}
