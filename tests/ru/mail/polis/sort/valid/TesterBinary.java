package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.mail.polis.sort.QuickSortBin;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;


/**
 * Created by Алена on 26.11.2016.
 */


@RunWith(value = Parameterized.class)
public class TesterBinary {

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Parameterized.Parameter
    public int[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<int[]> data()    {
        return Arrays.asList(new int[][]{
                {0b0000},
                {0b00, 0b00, 0b00, 0b00},
                {0b001, 0b010, 0b011, 0b100},
                {0b1101},
                {0b11111111111111111111111111111111, 0b00, 0b00111, 0b00},
                });
    }

    private boolean isSorted(int[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
        }
        return isSorted;
    }

    @Test
    public void test02_checkSortBin() throws IOException{
        Assert.assertTrue(isSorted(QuickSortBin.sort(array)));
    }
}

