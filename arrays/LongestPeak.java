package arrays;

import static java.lang.Math.max;

public class LongestPeak {

    public static int longestPeak(int[] array) {

        int step = 0;
        int stepsUp = 0;
        int stepsDown = 0;
        int longestPeak = -1;
        int arrLen = array.length;

        if (array.length < 3) return -1;

        while (step < arrLen) {

            while (step < arrLen && (array[step] == array[step + 1])) step++;

            while (step < arrLen && (array[step + 1] > array[step])) {
                stepsUp++;
                step++;
            }

            while (step < arrLen && (array[step + 1] < array[step])) {
                stepsDown++;
                step++;
            }

            if (stepsUp != 0 && stepsDown!= 0) {
                longestPeak = max(longestPeak, stepsUp + stepsDown);
            }

            stepsUp = 0;
            stepsDown = 0;

        }

        return longestPeak;
    }
}
