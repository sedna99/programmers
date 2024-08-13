import java.util.*;

class Solution {
    public int[] solution(String[] grid) {
        int[] box = new int[]{grid.length, grid[0].length()};
        Map<Integer, List<Integer>> vectorMap = Map.of(
                0, new ArrayList<Integer>(List.of(0, 1)),
                1, new ArrayList<Integer>(List.of(1, 0)),
                2, new ArrayList<Integer>(List.of(0, box[1] - 1)),
                3, new ArrayList<Integer>(List.of(box[0] - 1, 0))
        );

        Map<Character, Integer> directionMap = Map.of(
                'S', 0,
                'R', 1,
                'L', 3
        );

        Set<Point> pointSet = new HashSet<>();

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < box[0]; i++) {
            for (int j = 0; j < box[1]; j++) {
                for (int k = 0; k < 4; k++) {
                    Point point = new Point(i, j, k);
                    boolean flag = false;
                    int count = 0;
                    while (!pointSet.contains(point)) {
                        int nextDirection = (point.direction + directionMap.get(grid[point.x].charAt(point.y))) % 4;
                        pointSet.add(point);
                        point = new Point(
                                (point.x + vectorMap.get(nextDirection).get(0)) % box[0],
                                (point.y + vectorMap.get(nextDirection).get(1)) % box[1],
                                nextDirection
                        );
                        count++;
                        if (point.equals(new Point(i, j, k))) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) answer.add(count);
                }
            }
        }
        return answer.stream().sorted(Integer::compareTo).mapToInt(i -> i).toArray();
    }

    class Point {
        int x;
        int y;
        int direction;

        public Point(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object obj) {
            Point pt = (Point) obj;
            return x == pt.x && y == pt.y && direction == pt.direction;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, direction);
        }

        @Override
        public String toString() {
            return x + " " + y + " " + direction;
        }
    }
}