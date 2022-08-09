package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import static java.lang.Math.max;

public class OverlappingIntervals {

    public int[][] mergeOverlappingIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> mergedIntervals = new LinkedList<>();

        for (int[] interval : intervals) {

            if (mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < interval[0]) {
                mergedIntervals.add(interval);

            } else {
                mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], interval[1]);
            }
        }
        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
