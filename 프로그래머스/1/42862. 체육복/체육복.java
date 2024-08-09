import java.util.stream.IntStream;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] map = new int[n+2];
        Arrays.setAll(map, i->1);

        for(int lostIdx : lost) {
            map[lostIdx]--;
        }

        for(int reserveIdx : reserve) {
            map[reserveIdx]++;
        }

        for(int i = 1; i < n+1; i++) {
            if(map[i] == 0) {
                if(map[i-1] == 2) {
                    map[i-1] = 1;
                    map[i] = 1;
                } else if(map[i+1] == 2) {
                    map[i+1] = 1;
                    map[i] = 1;
                }
            }
        }

        return Long.valueOf(IntStream.of(map).filter(i -> i > 0).count()).intValue() - 2;
    }
}