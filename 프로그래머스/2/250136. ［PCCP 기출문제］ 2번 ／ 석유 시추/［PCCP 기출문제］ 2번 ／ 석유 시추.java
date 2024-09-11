import java.util.*;
import java.util.stream.Collectors;

class Solution {
    int[][] MAP;
    int[][] LAND;
    boolean[][] VISITED;
    int SIZE_X = 0;
    int SIZE_Y = 0;
    int areaIdx = 0;
    HashMap<Integer, HashSet<Integer>> resultSet = new HashMap<>();
    public int solution(int[][] land) {
        LAND = land;
        SIZE_X = land.length;
        SIZE_Y = land[0].length;
        MAP = new int[SIZE_X][SIZE_Y];
        VISITED = new boolean[SIZE_X][SIZE_Y];
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for(int x = 0; x < SIZE_X; x++) {
            for(int y = 0; y < SIZE_Y; y++) {
                if(MAP[x][y] != 0 || LAND[x][y] == 0) continue;
                resultMap.put(++areaIdx, markAndGetSize(x, y));
            }
        }
        OptionalInt res = resultSet.values().stream().mapToInt(set -> set.stream().mapToInt(i -> resultMap.getOrDefault(i, 0)).sum()).max();
        return res.isPresent() ? res.getAsInt() : 0;
    }

    public int markAndGetSize(int startX, int startY) {
        if (startX > SIZE_X - 1 || startY > SIZE_Y - 1 || startX < 0 || startY < 0) return 0;
        if (MAP[startX][startY] != 0 || LAND[startX][startY] == 0) return 0;

        ArrayDeque<int[]> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.push(new int[]{startX, startY});
        int size = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!ArrayDeque.isEmpty()) {
            int[] current = ArrayDeque.pop();
            int x = current[0];
            int y = current[1];

            if (x < 0 || y < 0 || x >= SIZE_X || y >= SIZE_Y || VISITED[x][y]) {
                continue;
            }

            VISITED[x][y] = true;

            if (MAP[x][y] != 0 || LAND[x][y] == 0) {
                continue;
            }

            MAP[x][y] = areaIdx;
            size++;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextX < SIZE_X && nextY >= 0 && nextY < SIZE_Y && !VISITED[nextX][nextY]) {
                    ArrayDeque.push(new int[]{nextX, nextY});
                }
            }

            HashSet<Integer> temp = resultSet.getOrDefault(y, new HashSet<>());
            temp.add(areaIdx);
            resultSet.put(y, temp);
        }

        return size;
    }
}