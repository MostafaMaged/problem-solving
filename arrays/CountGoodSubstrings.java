package arrays;

import java.util.HashMap;
import java.util.HashSet;

public class CountGoodSubstrings {

    public static void main(String[] args) {
        int res = countGoodSubstrings3("xyzzaz");
        System.out.println(res);
    }

    public int countGoodSubstrings1(String s) {

        int windowSize = 3;
        int windowStart = 0;
        int goodStringCount = 0;
        int characterCounter = 0;
        boolean goodString = true;
        Character currentChar;
        HashMap<Character, Integer> characterOccurrences = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {

            currentChar = s.charAt(windowEnd);
            characterOccurrences.put(currentChar, characterOccurrences.getOrDefault(currentChar, 0) + 1);

            if (windowEnd - windowStart + 1 == windowSize) {
                while (characterCounter < windowEnd) {

                    if (characterOccurrences.get(s.charAt(characterCounter)) > 1) {goodString = false;}

                    characterCounter++;
                }
                if (goodString) {goodStringCount++;}

                characterOccurrences.put(s.charAt(windowStart), characterOccurrences.get(s.charAt(windowStart)) - 1);

                goodString = true;
                windowStart++;
                characterCounter = windowStart;
            }
        }

        return goodStringCount;
    }

    public int countGoodSubstrings2(String s) {

        int goodStringCount = 0;

        for (int i = 2; i < s.length(); i++) {

            if (s.charAt(i) != s.charAt(i - 1) && s.charAt(i) != s.charAt(i - 2) && s.charAt(i - 1) != s.charAt(i - 2)) {
                goodStringCount++;
            }
        }

        return goodStringCount;
    }

    public static int countGoodSubstrings3(String s) {

        int[] characterOccurrences = new int[26];
        int goodStringCnt = 0;
        int repetitions = 0;
        int removedCharIdx;

        for (int idx = 0; idx < s.length(); idx++) {

            if (++characterOccurrences[s.charAt(idx) - 'a'] >= 2) repetitions++;

            if (idx >= 3) {

                removedCharIdx = s.charAt(idx - 3)  - 'a';
                if (characterOccurrences[removedCharIdx] >= 2) repetitions--;
                characterOccurrences[removedCharIdx]--;
            }

            if (idx >= 2 && repetitions == 0) {
                goodStringCnt++;
            }
        }

        return goodStringCnt;
    }
}
