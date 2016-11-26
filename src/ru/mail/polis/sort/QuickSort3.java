package ru.mail.polis.sort;

import java.util.Random;

/**
 * Created by Алена on 25.11.2016.
 */
public class QuickSort3 {
   public static final Random RND = new Random();

    public static int[] sort(int[] a) {
        qsort(a, 0, a.length - 1);
        return a;
    }

    private static void qsort(int[] a, int left, int right) {
        if (right <= left) return;
        int lt =left;
        int i=left+1;
        int gt = right;
        int index=left+RND.nextInt(right-left);
        int v=a[index];
        swap(a,index,left);
        while (i<=gt) {
            int cmp = compareTo(a[i],v);
            if (cmp<0) swap(a,lt++,i++);
            else if (cmp>0) swap(a, i,gt--);
            else i++;
        }
       // swap(a,index,left);
        qsort(a,left,lt-1);
        qsort(a,gt+1,right);
    }

    private static int compareTo(int a, int b) {
        if (a<b) return -1;
        else if (a>b) return 1;
        else return 0;
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
