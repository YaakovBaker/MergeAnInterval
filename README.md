# MergeAnInterval
Intro to Algorithms project for merging an interval

The problem:
Merge an interval into an existing set of disjoint intervals. 

The Algorithm: Compare every interval in the set of disjoint intervals to the new interval. If they are in each other's range, then take the smaller left and bigger right and create a new interval to compare against. Add all intervals not in the new interval(s) range into a return set. Then add the new interval to that set. My solution has constructed a new set of disjoint intervals in O(n) time; The expectation was to solve this problem in O(nlogn).

Next:
I plan to clean the code when I have time, I made it messy when writing it and didn't go back to clean it.
