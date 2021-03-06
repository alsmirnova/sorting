package ru.mail.polis.sort;

/**
 * Created by Алена on 22.11.2016.
 */
public class MergeSortUPD {




    public static int[] sort(int[] a) {
        int n = a.length;
        for (int stp2 = 1; stp2 <= n; stp2 *= 2)
            for (int i = 0; i < n; i += stp2) {
                int size = Math.min(n, i + stp2) - i;
                swapgroup(a, size, 0, i);      // для удобства реализации перемещаем
                merge(a, size);                // требуемый кусок масcива в начало
                swapgroup(a, size, 0, i);      // там его сортируем и возвращаем обратно
            }
        if (n > 16)
            merge(a, n);

        return a;

    }


    // сляние двух групп елементов одинокового размера
    public static void mergegroup(int a[], int n, int st1, int st2, int st3) {
        swapgroup(a, n, st1, st3);
        int take1 = 0;
        int take2 = 0;
        for (int i = 0; i < 2 * n; i++) {
            if ((take2 == n) || ((take1 < n) && (a[take1 + st3] < a[take2 + st2]))) {
                int t = a[st1 + i];
                a[st1 + i] = a[take1 + st3];
                a[take1 + st3] = t;
                take1++;
            } else {
                int t = a[st1 + i];
                a[st1 + i] = a[take2 + st2];
                a[take2 + st2] = t;
                take2++;
            }
        }
    }


    // сортировка выбором
    public static void slowsort(int a[], int st, int en) {
        for (int i = st; i < en; i++)
            for (int j = i + 1; j < en; j++) {
                if (a[i] > a[j]) {
                    int k = a[i];
                    a[i] = a[j];
                    a[j] = k;
                }
            }
    }


    // обмен местами двух групп елементов одинакового размера
    public static void swapgroup(int a[], int n, int st1, int st2) {
        for (int i = 0; i < n; i++) {
            int k = a[st1 + i];
            a[st1 + i] = a[st2 + i];
            a[st2 + i] = k;
        }
    }



    public static void merge(int[] a, int n) {
        if (n <= 16) {
            slowsort(a, 0, n);
            return;
        }

        // разрез на группы длиной корень из n
        int sizegroup = (int) Math.sqrt(n);
        int remainder = n % sizegroup;
        int numofgrp = n / sizegroup - 1;

        // поиск конца первого массива
        int posgap = 0;
        while ((posgap < sizegroup * numofgrp) && (a[posgap] <= a[posgap + 1]))
            posgap++;

        // обмен группы содержащей конец первого массива  с последней и обьединение с остатком
        swapgroup(a, sizegroup, numofgrp * sizegroup, posgap - posgap
                % sizegroup);
        remainder += sizegroup;

        // сортировка групп по первому елементу(в случае равенства по последнему)
        for (int i = 0; i < numofgrp - 1; i++) {
            int minnum = i;
            for (int j = i + 1; j < numofgrp; j++)
                if ((a[j * sizegroup] < a[minnum * sizegroup])
                        || ((a[j * sizegroup] == a[minnum * sizegroup])
                        && (a[(j + 1) * sizegroup - 1] < a[(minnum + 1) * sizegroup - 1])))
                    minnum = j;
            swapgroup(a, sizegroup, i * sizegroup, minnum * sizegroup);
        }

        // поочередное слияние групп
        for (int i = 0; i < numofgrp - 1; i++) {
            mergegroup(a, sizegroup, i * sizegroup, (i + 1) * sizegroup,
                    numofgrp * sizegroup);
        }

        // сортировка конца массива
        slowsort(a, n - 2 * remainder, n);

        // поочередное слияние групп в обратную сторону
        for (int i = n - 2 * remainder; i >= remainder; i -= remainder)
            mergegroup(a, remainder, i - remainder, i, n - remainder);

        // сортировка начала и конца массива
        slowsort(a, 0, 2 * remainder);
        slowsort(a, n - remainder, n);
    }



    /*void testsort() throws IOException {
        int n = 100000;
        int[] a = new int[n];
        Random st = new Random();
        for (int i = 0; i < n; i++)
            a[i] = st.nextInt();
        int[] b = a.clone();
        Arrays.sort(b);
        sort(a);
        for (int i = 0; i < n; i++)
            if (a[i] != b[i])
                throw new AssertionError();
    }
    */

    public static void main(String[] args) {
        int[] a=Helper.gen(10);
        for (int x: a) System.out.print(x+" ");
        sort(a);
        System.out.println();
        for (int x: a) System.out.print(x+" ");
    }
}

