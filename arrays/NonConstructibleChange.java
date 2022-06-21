package arrays;

import java.util.*;
import java.util.stream.Collectors;

public class NonConstructibleChange {

    public static void main(String[] args) {
        int[] input = new int[] {5, 7, 1, 1, 2, 3, 22};
        int expected = 20;
        var actual = new NonConstructibleChange().nonConstructibleChange(input);
    }

    public int nonConstructibleChange(int[] coins) {

        int mostConstructibleChange = 0;

        Arrays.sort(coins);

        for (int coin: coins) {
            if (coin > mostConstructibleChange + 1) {
                return mostConstructibleChange + 1;
            }

            mostConstructibleChange += coin;
        }

        return mostConstructibleChange + 1;
    }
}
