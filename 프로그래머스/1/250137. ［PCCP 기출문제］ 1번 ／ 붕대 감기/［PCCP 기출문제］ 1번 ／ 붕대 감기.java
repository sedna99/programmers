import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int count = bandage[0];
        int current = health;
        int lastAttack = 0;

        int defaultBandageCount, additionalBandageCount;
        for (int[] attack: attacks) {
            defaultBandageCount = attack[0] - lastAttack - 1;
            additionalBandageCount = defaultBandageCount / count;

            lastAttack = attack[0];
            current = Math.min(health, current + (defaultBandageCount * bandage[1]));
            current = Math.min(health, current + (additionalBandageCount * bandage[2]));

            current -= attack[1];
            if (current <= 0) {
                return -1;
            }
        }
        return current;
    }
}