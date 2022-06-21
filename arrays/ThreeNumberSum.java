package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        Arrays.sort(array);

        List<Integer[]> triplets = new ArrayList<Integer[]>();
        int left;
        int right;
        int currentSum;
        Integer[] newTriplet;

        for (int idx = 0; idx < array.length - 2; idx++) {
            left = idx + 1;
            right = array.length - 1;

            while (left < right) {
                currentSum = array[idx] + array[left] + array[right];

                if (currentSum == targetSum) {
                    newTriplet = new Integer[]{array[idx], array[left], array[right]};
                    triplets.add(newTriplet);
                    left++;
                    right--;

                } else if (currentSum > targetSum) {
                    right--;

                } else {
                    left++;
                }
            }
        }

        return triplets;
    }
}
