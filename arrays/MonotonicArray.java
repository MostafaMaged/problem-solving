package arrays;

public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {

        boolean increasing = true;
        boolean decreasing = true;

        for (int idx = 1; idx < array.length; idx++) {
            if (array[idx] < array[idx - 1]) increasing = false;
            if (array[idx] > array[idx - 1]) decreasing = false;
        }

        return !(increasing || decreasing);
    }
}
