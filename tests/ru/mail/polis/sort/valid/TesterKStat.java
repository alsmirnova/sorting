package ru.mail.polis.sort.valid;

import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.InsertSort;
import ru.mail.polis.sort.KStatistics;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

@RunWith(value = Parameterized.class)

public class TesterKStat {

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Parameterized.Parameter
    public static int[] array;
    public static final Random RND = new Random();
    public static int k;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<int[]> data() {
        return Arrays.asList(new int[][]{
                {0},
                {0, 0, 0, 0},
                {4, 3, 2, 1},
                {0, 1, 1, 0},
                {1, 2, 3, 4},
                {1},
                {Integer.MAX_VALUE, 0, 0, Integer.MIN_VALUE},
                Helper.gen(1),
                Helper.gen(10),
                Helper.gen(100),
                Helper.gen(1000),
                Helper.gen(10000),
        });
    }

       public int getK() {
        return k=RND.nextInt(array.length);
    }

    private boolean isFound(int m) {
        boolean isFound = true;
        int[] aa = array;
        InsertSort.sort(aa);
        if (m == aa[k]) return isFound;
        else return !isFound;
    }

    @Test
    public void test03_checkKStatistics() throws IOException {
        Assert.assertTrue(isFound(KStatistics.findOrderStatistic(array, getK())));
    }

}