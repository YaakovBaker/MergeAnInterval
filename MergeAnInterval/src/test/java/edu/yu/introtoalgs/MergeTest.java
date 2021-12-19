package edu.yu.introtoalgs;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.TreeSet;

import edu.yu.introtoalgs.MergeAnInterval.Interval;
public class MergeTest {

    @Test
    public void mergeIntervalsTest() {
        Set<Interval> intervals = new TreeSet<>();
        Interval interval = new Interval(1, 5);
        Interval interval2 = new Interval(7, 9);
        Interval interval3 = new Interval(3, 4);
        Interval interval4 = new Interval(6, 8);

        intervals.add(interval);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);

        Interval merger = new Interval(1, 9);
        Set<Interval> expected = MergeAnInterval.merge(intervals, merger);
        assertEquals(1, expected.size());
        assertTrue(expected.contains(merger));
    }

    @Test
    public void mergeIntervalsTest2(){
        Set<Interval> intervals = new TreeSet<>();
        Interval interval = new Interval(3, 4);

        intervals.add(interval);

        Interval merger = new Interval(0, 2);
        Set<Interval> expected = MergeAnInterval.merge(intervals, merger);
        assertEquals(2, expected.size());
        assertTrue(expected.contains(merger));
        assertTrue(expected.contains(interval));
    }

    @Test
    public void mergeIntervalsTest3(){
        Set<Interval> intervals = new TreeSet<>();
        Interval interval = new Interval(1, 4);

        intervals.add(interval);

        Interval merger = new Interval(0, 2);
        Set<Interval> expected = MergeAnInterval.merge(intervals, merger);
        Interval i2 = null;
        for(Interval i: expected){
            i2 = i;
            System.out.println(i);
        }
        System.out.println(merger);
        boolean flag = expected.contains(merger);
        System.out.println(flag);
        boolean flag2 = merger.equals(i2);
        System.out.println(flag2);
        assertEquals(1, expected.size());
        assertFalse(flag);//returning true
        assertFalse(expected.contains(interval));
        int left = merger.left;
        int right = interval.right;
        Interval newInterval = expected.iterator().next();
        assertEquals(left, newInterval.left);
        assertEquals(right, newInterval.right);
    }

    @Test
    public void mergeCascade(){
        Set<Interval> intervals = new TreeSet<>();
        Interval interval = new Interval(1, 2);
        Interval interval2 = new Interval(3, 4);

        intervals.add(interval);
        intervals.add(interval2);

        Interval merger = new Interval(0, 3);
        Set<Interval> expected = MergeAnInterval.merge(intervals, merger);
        assertEquals(1, expected.size());
        assertFalse(expected.contains(merger));//returning true 
        int left = merger.left;
        int right = interval2.right;
        Interval newInterval = expected.iterator().next();
        System.out.println(newInterval);
        assertEquals(left, newInterval.left);
        assertEquals(right, newInterval.right);
    }

    @Test
    public void mergeCascade2(){
        Set<Interval> intervals = new TreeSet<>();
        Interval interval = new Interval(1, 5);
        Interval interval2 = new Interval(7, 9);

        intervals.add(interval);
        intervals.add(interval2);

        Interval merger = new Interval(3, 8);
        Set<Interval> expected = MergeAnInterval.merge(intervals, merger);
        assertEquals(1, expected.size());
        assertFalse(expected.contains(merger));//returning true 
        int left = interval.left;
        int right = interval2.right;
        Interval newInterval = expected.iterator().next();
        System.out.println(newInterval);
        assertEquals(left, newInterval.left);
        assertEquals(right, newInterval.right);
    }
}
