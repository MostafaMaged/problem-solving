package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] array) {

        int startingCol = 0;
        int endingCol = array[0].length - 1;
        int startingRow = 0;
        int endingRow = array.length - 1;
        ArrayList<Integer> traversedArr = new ArrayList<>();

        while (startingCol <= endingCol && startingRow <= endingRow) {

            for (int col = startingCol; col <= endingCol; col++) {
                traversedArr.add(array[startingRow][col]);
            }

            for (int row = startingRow + 1; row <= endingRow; row++) {
                traversedArr.add(array[row][endingCol]);
            }

            for (int col = endingCol - 1; col >= startingCol; col--) {
                if (startingRow == endingRow) break;
                traversedArr.add(array[endingRow][col]);
            }

            for (int row = endingRow - 1; row >= startingRow + 1; row--) {
                if (startingCol == endingCol) break;
                traversedArr.add(array[row][startingCol]);
            }

            startingRow++;
            endingRow--;
            startingCol++;
            endingCol--;
        }

        return traversedArr;
    }
}
