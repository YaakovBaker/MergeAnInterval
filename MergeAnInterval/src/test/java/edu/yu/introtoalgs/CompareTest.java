package edu.yu.introtoalgs;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Set;
import java.util.TreeSet;

import edu.yu.introtoalgs.MergeAnInterval.Interval;

public class CompareTest {
    
    @Test
    public void compareLess1(){
        Interval interval = new Interval(1,2);//this
        Interval interval2 = new Interval(1, 3);//other
        int compare = interval.compareTo(interval2);
        System.out.println(compare);
        assertEquals(-1, compare);
    }

    @Test
    public void compareMore1(){
        Interval interval = new Interval(1,5);//this
        Interval interval2 = new Interval(1, 3);//other
        int compare = interval.compareTo(interval2);
        System.out.println(compare);
        assertEquals(1, compare);
    }

    @Test
    public void compareSame(){
        Interval interval = new Interval(1,2);//this
        Interval interval2 = new Interval(1, 2);//other
        int compare = interval.compareTo(interval2);
        System.out.println(compare);
        assertEquals(0, compare);
    }

    @Test
    public void compareLess2(){
        Interval interval = new Interval(1,5);//this
        Interval interval2 = new Interval(2, 5);//other
        int compare = interval.compareTo(interval2);
        System.out.println(compare);
        assertEquals(-1, compare);
    }

    @Test
    public void compareMore2(){
        Interval interval = new Interval(3,5);//this
        Interval interval2 = new Interval(2, 5);//other
        int compare = interval.compareTo(interval2);
        System.out.println(compare);
        assertEquals(1, compare);
    }

    @Test
    public void compareSetTest(){
        Set<Interval> intervals = new TreeSet<>();
        Interval interval = new Interval(1, 5);
        Interval interval2 = new Interval(7, 9);
        Interval interval3 = new Interval(3, 4);
        Interval interval4 = new Interval(6, 8);

        intervals.add(interval);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);

        for(Interval i : intervals){
            System.out.println(i);
        }

        assertTrue(intervals.contains(interval));
        assertTrue(intervals.contains(interval2));
        assertTrue(intervals.contains(interval3));
        assertTrue(intervals.contains(interval4));
    }

    @Test
    public void compareSetTestEqualRights(){
        Set<Interval> intervals = new TreeSet<>();
        Interval interval = new Interval(1, 5);
        Interval interval2 = new Interval(7, 9);
        Interval interval3 = new Interval(3, 5);
        Interval interval4 = new Interval(6, 9);

        intervals.add(interval);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);

        for(Interval i : intervals){
            System.out.println(i);
        }

        assertTrue(intervals.contains(interval));
        assertTrue(intervals.contains(interval2));
        assertTrue(intervals.contains(interval3));
        assertTrue(intervals.contains(interval4));

        Interval[] interv = new Interval[4];
        interv = intervals.toArray(interv);
        assertEquals(interval, interv[0]);
        assertEquals(interval2, interv[3]);
        assertEquals(interval3, interv[1]);
        assertEquals(interval4, interv[2]);
    }
}
