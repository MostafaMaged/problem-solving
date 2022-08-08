package arrays;

import static java.lang.Math.max;

public class ArrayOfProducts {

    public int[] arrayOfProductsSol1(int[] array) {

        int arrLen = array.length;
        int[] result = new int[arrLen];

        result[0] = 1;

        for (int pointer = 1; pointer < arrLen; pointer++) {
            result[pointer] = array[pointer - 1] * result[pointer - 1];
        }

        int rightVal = 1;

        for (int pointer = arrLen - 2; pointer >= 0; pointer--) {
            result[pointer] = result[pointer] * rightVal;
            rightVal *= result[pointer] * array[pointer];
        }

        return result;
    }
}
