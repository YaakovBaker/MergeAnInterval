package edu.yu.introtoalgs;

import java.util.*;

/** Implements the "Add an Interval To a Set of Intervals" semantics defined in
 * the requirements document.
 * 
 * @author Avraham Leff 
 */

public class MergeAnInterval {

  /** An immutable class, holds a left and right integer-valued pair that
   * defines a closed interval
   *
   * IMPORTANT: students may not modify the semantics of the "left", "right"
   * instance variables, nor may they use any other constructor signature.
   * Students may (are encouraged to) add any other methods that they choose,
   * bearing in mind that my tests will ONLY DIRECTLY INVOKE the constructor
   * and the "merge" method.
   */
  public static class Interval implements Comparable<Interval>{
    public final int left;
    public final int right;

    /** Constructor
     * 
     * @param left the left endpoint of the interval, may be negative
     * @param right the right endpoint of the interval, may be negative
     * @throws IllegalArgumentException if left is >= right
     */
    public Interval(int l, int r) {
      if( l >= r ){
        throw new IllegalArgumentException("left is greater than or equal to right: invalid arguments");
      }
      this.left = l;
      this.right = r;
    }

    private int isMergable(Interval o){
      if( this.right < o.left ){//this.right is less than o.left: no merge
        return -1;
      }
      else if( this.left > o.right ){//this.left is greater than o.right: no merge
        return 1;
      }
      else{//this is equal to o or the left and right fields are within range of o: merge
        return 0;
      }
    }

    @Override
    public int	compareTo(Interval o) {
      if( this.right < o.right ){
        return -1;
      }else if( this.right > o.right ){
        return 1;
      }else{
        if( this.left > o.left ){
          return 1;
        }else if( this.left < o.left ){
          return -1;
        }else{
          return 0;
        }
      }
      
    }

    @Override
    public int hashCode() {
      return 0x7FFFFFFF & (31 * left) + (53 * right);
    }
    

    @Override
    public boolean equals(Object obj) {
      if( obj == null ){
        return false;
      }
      Interval other = null;
      if( obj instanceof Interval ){
        other = (Interval)obj;
        if( this == other || ( (this.right == other.right) && (this.left == other.left) ) || (this.hashCode() == other.hashCode()) ){
          return true;
        }
      }else{
        return false;
      }
      return false;
    }

    @Override
    public String toString() {
        return "Interval(" + left + ", " + right + ")";
    }

  } // Interval class

  /** Merges the new interval into an existing set of disjoint intervals.
   *
   * @param intervals an set of disjoint intervals (may be empty)
   * @param newInterval the interval to be added
   * @return a new set of disjoint intervals containing the original intervals
   * and the new interval, merging the new interval if necessary into existing
   * interval(s), to preseve the "disjointedness" property.
   * @throws IllegalArgumentException if either parameter is null
   */
  public static Set<Interval> merge (final Set<Interval> intervals, Interval newInterval)
  {
    if ( (intervals == null) || (newInterval == null) ){
      throw new IllegalArgumentException("Either argument is null");
    }
    Set<Interval> result = new TreeSet<>();
    if(intervals.isEmpty()){
      result.add(newInterval);
      return result;
    }
    int count = 0;
    Interval[] mergeHeap = new Interval[intervals.size() + 2];
    mergeHeap[++count] = newInterval;
    //load mergeheap with intervals. if an interval can be merged with newInterval merge them and replace newInterval with newInterval
    //those that don't merge get added to heap
    //O(n)
    for(Interval interval : intervals){
      int mergable = newInterval.isMergable(interval);
      if(mergable == 0){//newInterval is within range so merge
        //take the smaller left and the bigger right of the interval and replace newInterval with the merged interval, so that we can check the next interval
        newInterval = new Interval(Math.min(newInterval.left, interval.left), Math.max(newInterval.right, interval.right));
        mergeHeap[1] = newInterval;
      }
      else{//not in range of eachother so dont merge and just add these disjoint to heap
        mergeHeap[++count] = interval;
      }
    }
    for(int el = 1; el <= count; el++){
      result.add(mergeHeap[el]);
    }
    return result;
  }
}
