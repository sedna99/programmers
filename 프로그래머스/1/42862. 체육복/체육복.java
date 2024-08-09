import java.util.stream.IntStream;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] map = new int[n];
        Arrays.setAll(map, i->1);
        
        for(int lostIdx : lost) {
            map[lostIdx - 1]--;
        }

        for(int reserveIdx : reserve) {
            map[reserveIdx - 1]++;
        }

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                if(map[i+1] == 2) {
                    map[i+1] = 1;
                    map[i] = 1;
                }
            }
            else if(i == n-1) {
                if(map[i] == 0) {
                    if (map[i-1] == 2) {
                        map[i-1] = 1;
                        map[i] = 1;
                    }
                }
            }
            else if(map[i] == 0) {
                if(map[i-1] == 2) {
                    map[i-1] = 1;
                    map[i] = 1;
                } else if(map[i+1] == 2) {
                    map[i+1] = 1;
                    map[i] = 1;
                }
            }
        }
        return Long.valueOf(IntStream.of(map).filter(i -> i > 0).count()).intValue();
    }
}