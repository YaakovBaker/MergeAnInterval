package edu.yu.introtoalgs;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import edu.yu.introtoalgs.MergeAnInterval.Interval;

public class HashTest {

    public int hash(Interval i){
        return 0x7FFFFFFF & (31 * i.left) + (53 * i.right);
    }
    
    @Test
    public void hashTest1(){
        Interval interval = new Interval(1,2);//this
        int hashCode = interval.hashCode();
        int hashCompare = hash(interval);
        System.out.println(hashCode);
        assertEquals(hashCompare, hashCode);
    }

    @Test
    public void hashTest2(){
        Interval interval = new Interval(57,499);//this
        int hashCode = interval.hashCode();
        int hashCompare = hash(interval);
        System.out.println(hashCode);
        assertEquals(hashCompare, hashCode);
    }

    @Test
    public void hashSetTest(){
        Set<Interval> intervals = new HashSet<>();
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
            System.out.println(hash(i));
        }
        assertTrue(intervals.contains(interval));
        assertTrue(intervals.contains(interval2));
        assertTrue(intervals.contains(interval3));
        assertTrue(intervals.contains(interval4));
    }

    @Test 
    public void hashCollision(){
        Set<Interval> intervals = new HashSet<>();
        Interval interval = new Interval(1, 5);
        Interval interval2 = new Interval(7, 9);
        Interval interval3 = new Interval(3, 4);
        Interval interval4 = new Interval(6, 8);
        Interval interval5 = new Interval(1, 5);

        intervals.add(interval);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        intervals.add(interval5);

        for(Interval i : intervals){
            System.out.println(i);
            System.out.println(hash(i));
        }
        assertTrue(intervals.contains(interval));
        assertTrue(intervals.contains(interval2));
        assertTrue(intervals.contains(interval3));
        assertTrue(intervals.contains(interval4));
        assertTrue(intervals.contains(interval5));
        assertEquals(interval, interval5);
    }

    @Test 
    public void bigHash(){
        Interval interval = new Interval(20000000, 2147483647);
        System.out.println(hash(interval));
        assertEquals(hash(interval), interval.hashCode());
    }
}
