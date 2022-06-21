package arrays;

import java.util.Arrays;

public class SmallestDifference {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

        int arrOnePointer = 0;
        int arrTwoPointer = 0;
        int arrOneVal;
        int arrTwoVal;
        int smallestDiff = Integer.MAX_VALUE;
        int currentDiff;
        int[] resultArr = new int[2];

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        while (arrOnePointer < arrayOne.length && arrTwoPointer < arrayTwo.length) {

            arrOneVal = arrayOne[arrOnePointer];
            arrTwoVal = arrayTwo[arrTwoPointer];

            if (arrOneVal < arrTwoVal) {
                currentDiff = arrTwoVal - arrOneVal;
                arrOnePointer++;

            } else if (arrOneVal > arrTwoVal){
                currentDiff = arrOneVal - arrTwoVal;
                arrTwoPointer++;

            } else {

                return new int[] {arrOneVal, arrTwoVal};
            }

            if (currentDiff < smallestDiff) {
                smallestDiff = currentDiff;
                resultArr = new int[] {arrOneVal, arrTwoVal};
            }
        }

        return resultArr;
    }
}
