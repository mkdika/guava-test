package com.mkdika.guavatest;

import com.google.common.collect.MinMaxPriorityQueue;
import com.google.common.collect.Ordering;
import java.util.Arrays;
import junitparams.JUnitParamsRunner;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 *
 * Given N of array, find out K element of the highest/lowest (min/max) value.
 * This is min/max heap data structure technique, using Guava's
 * MinMaxPriorityQueue
 *
 */
@RunWith(JUnitParamsRunner.class)
public class MinMaxHeapTest {

    private static final Ordering<Integer> INT_COMPARATOR_REVERSE = Ordering.natural().reverse();
    int k = 3;
    int[] n = {15, 10, 4, 1, 5, 2, 3, 0, 30, -1};

    @Test
    public void test_min_heap() {
        System.out.println("test_min_heap");
        MinMaxPriorityQueue<Integer> minHeap = MinMaxPriorityQueue
                .maximumSize(k)
                .create();
        for (int i : n) {
            minHeap.add(i);
        }
        Integer[] r = minHeap.toArray(new Integer[minHeap.size()]);
        Arrays.sort(r);
        System.out.println("size: "+r.length+", result: " + Arrays.toString(r));
        assertThat(r, equalTo(new Integer[]{-1, 0, 1}));
    }

    @Test
    public void test_max_heap() {
        System.out.println("test_max_heap");
        MinMaxPriorityQueue<Integer> maxHeap = MinMaxPriorityQueue
                .orderedBy(INT_COMPARATOR_REVERSE)
                .maximumSize(k)
                .create();
        for (int i : n) {
            maxHeap.add(i);
        }
        Integer[] r = maxHeap.toArray(new Integer[maxHeap.size()]);
        System.out.println("size: "+r.length+", result: " + Arrays.toString(r));
        assertThat(r, equalTo(new Integer[]{30,15,10}));
    }

}
