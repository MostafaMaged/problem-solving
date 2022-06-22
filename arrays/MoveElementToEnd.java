package arrays;

import java.util.ArrayList;
import java.util.List;

public class MoveElementToEnd {

    public static List<Integer> moveElementToEndFirstSolution(List<Integer> array, int toMove) {

        int front = 0;
        int rare = array.size() - 1;
        int frontVal;
        int rareVal;
        int temp;

        while (front < rare) {

            frontVal = array.get(front);
            rareVal = array.get(rare);

            if (frontVal == toMove && rareVal != toMove) {
                array.set(rare, frontVal);
                array.set(front, rareVal);
                front++;
                rare--;

            } else if (frontVal != toMove && rareVal == toMove) {
                front++;
                rare--;

            } else if (frontVal != toMove && rareVal != toMove) {
                front++;

            } else if (frontVal == toMove && rareVal == toMove) {
                rare--;
            }
        }

        return array;
    }

    public static List<Integer> moveElementToEndSecondSolution(List<Integer> array, int toMove) {

        int front = 0;
        int rare = array.size() - 1;
        int frontVal;

        while (front < rare) {

            frontVal = array.get(front);

            while (array.get(rare) == toMove && front < rare) rare--;

            if (frontVal == toMove) swap(array, front, rare);

            front++;
        }

        return array;
    }

    public static void swap(List<Integer> array, int toMove, int toReplace) {

        int temp = array.get(toReplace);
        int toMoveVal = array.get(toMove);

        array.set(toReplace, toMoveVal);
        array.set(toMove, temp);
    }
}
