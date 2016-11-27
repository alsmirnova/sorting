package ru.mail.polis.bench;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.KStatistics;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Алена on 27.11.2016.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class BenchKStat {
    public static final Random RND = new Random();
    int[][] data;
    int[] curr;
    int index;
    int k;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new int[10][10000];
        for (int i = 0; i < 10; i++) {
            //define arrays here
            data[i] = Helper.gen(10000);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        k=RND.nextInt(data[index].length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureSort() {
        KStatistics.findOrderStatistic(curr,k);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(AverageTimeBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }



}
