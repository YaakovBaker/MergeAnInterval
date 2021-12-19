package edu.yu.introtoalgs;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import edu.yu.introtoalgs.MergeAnInterval.Interval;

/**
 * Unit test for simple App.
 */
public class IntervalTest
{ 
   @Test
   public void testInterval()
   {
      Interval interval = new Interval(1, 5);
      assertEquals(1, interval.left);
      assertEquals(5, interval.right);
   }

   @Test
   public void testInterval2()
   {
      try
      {
        Interval interval2 = new Interval(5, 1);
      }
      catch (IllegalArgumentException e)
      {
        System.out.println("T2 Exception thrown: left >= right"); 
      }
   }

   @Test
   public void testInterval3()
   {
      try
      {
        Interval interval3 = new Interval(1, 1);
      }
      catch (IllegalArgumentException e)
      {
        System.out.println("T3 Exception thrown: left >= right:"); 
      }
   }

   @Test
   public void testInterval4()
   {
       boolean flag = false;
      try
      {
        Interval interval4 = new Interval(1, 5);
        flag = true;
      }
      catch (IllegalArgumentException e)
      {
        System.out.println("T4 Exception thrown: left >= right:"); 
      }
        assertTrue(flag);
   }
    
}
