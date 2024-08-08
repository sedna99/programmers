import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(int[] numbers, String hand) {
        int[] parsed = Arrays.stream(numbers).map(i -> i == 0 ? 11 : i).toArray();
        char defaultHand = hand.toUpperCase().charAt(0);
        int[] rCursor = new int[] {3,2};
        int[] lCursor = new int[] {3,0};
        char[] result = new char[parsed.length];
        for(int i = 0; i < parsed.length; i++) {
            int number = parsed[i];
            if(number%3 == 2) {
                int[] numberCoord = {number/3, 1};
                char nextHand = judge(rCursor, lCursor, numberCoord, defaultHand);
                result[i] = nextHand;
                if(nextHand == 'R') rCursor = numberCoord;
                else lCursor = numberCoord;
            }
            else if(number%3 == 0) {
                result[i] = 'R';
                rCursor = new int[] {number/3 - 1, 2};
            }
            else if(number%3 == 1) {
                result[i] = 'L';
                lCursor = new int[] {number/3, 0};
            }
        }
        return String.valueOf(result);
    }

    public char judge(int[] rCursor, int[] lCursor, int[] coord, char defaultHand) {
        int rDist = Math.abs(rCursor[0] - coord[0]) + Math.abs(rCursor[1] - coord[1]);
        int lDist = Math.abs(lCursor[0] - coord[0]) + Math.abs(lCursor[1] - coord[1]);
        if(rDist > lDist) return 'L';
        else if(rDist < lDist) return 'R';
        else return defaultHand;
    }
}