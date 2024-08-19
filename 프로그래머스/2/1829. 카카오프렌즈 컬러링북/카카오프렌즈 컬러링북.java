import java.util.*;

class Solution {
    int SIZE_X = 0;
    int SIZE_Y = 0;
    int[][] PICTURE;
    int[][] AREAMAP;
    int areaIdx = 0;
    public int[] solution(int m, int n, int[][] picture) {
        SIZE_X = m;
        SIZE_Y = n;
        PICTURE = picture;
        HashMap<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        AREAMAP = new int[SIZE_X][SIZE_Y];
        for(int i = 0; i < SIZE_X; i++) {
            for(int j = 0; j < SIZE_Y; j++) {
                if(AREAMAP[i][j] != 0 || PICTURE[i][j] == 0) continue;
                resultMap.put(++areaIdx, markAndGetSize(i, j, PICTURE[i][j]));
            }
        }
        return new int[] { resultMap.size(), resultMap.values().stream().max(Integer::compareTo).get() };
    }

    public int markAndGetSize(int x, int y, int val) {
        if(x > SIZE_X - 1 || y > SIZE_Y - 1 || x < 0 || y < 0) return 0;
        if(AREAMAP[x][y] != 0 || PICTURE[x][y] == 0) return 0;
        if(AREAMAP[x][y] == 0 && PICTURE[x][y] != val) return 0;
        AREAMAP[x][y] = areaIdx;
        return markAndGetSize(x - 1, y, val) + markAndGetSize(x + 1, y, val) + markAndGetSize(x, y - 1, val) + markAndGetSize(x, y + 1, val) + 1;
    }
}