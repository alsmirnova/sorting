package ru.mail.polis.sort;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Helper {

    private static final Random r = ThreadLocalRandom.current();

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static int[] gen(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Helper.swap(a, i, j);
        }
        return a;
    }

    public static int[] order(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        return a;
    }

    public static int[] disorder(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = a.length-1-i;
        }
        return a;
    }

    public static int[] qsortcase(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        for (int i = 0; i<n; i++) {
            swap(a,i,i/2);

        }
        int i1=-1,i2=-1;
        for (int i=0;i<n;i++) {
            if (a[i]==1) i1=i;
            else if (a[i]==2) i2=i;
            if (i1!=-1 && i2!=-1) break;
        }
        if (n>2)swap(a,i1,i2);
        return a;

    }

    public static int[] repeatkeys(int n) {
        int[] a=new int[n];
        for (int i=0; i<a.length-1; i+=2) {
            a[i]=r.nextInt(10);
            a[i+1]=i;
        }
        a[a.length-1]=a[0];
        return a;
    }
}
