import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(int[][] lines) {
        List<Line> lineList = Arrays.stream(lines).map(l -> new Line(l[0], l[1], l[2])).collect(Collectors.toList());
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < lineList.size(); i++) {
            List<Line> tempLineList = lineList.subList(i, lineList.size());
            for(int j = 0; j < tempLineList.size(); j++) {
                Line a = lineList.get(i);
                Line b = tempLineList.get(j);
                if((!a.isParallel(b)) && a.isIntegerPoint(b)) {
                    points.add(a.getIntersection(b));
                }
            }
        }
        int minX = (int)points.stream().min(Comparator.comparingLong(p -> p.x)).get().x;
        int maxX = (int)points.stream().max(Comparator.comparingLong(p -> p.x)).get().x;
        int minY = (int)points.stream().min(Comparator.comparingLong(p -> p.y)).get().y;
        int maxY = (int)points.stream().max(Comparator.comparingLong(p -> p.y)).get().y;

        char[][] map = new char[maxX - minX + 1][maxY - minY + 1];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                map[i][j] = '.';
            }
        }

        for(Point point : points) {
            map[maxX - (int)point.x][(int)point.y - minY] = '*';
        }

        String[] result = new String[maxX - minX + 1];
        for(int i = 0; i<map.length; i++) {
            result[i] = new String(map[i]);
        }
        return result;
    }

    static class Line {
        int a;
        int b;
        int c;

        Line(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        boolean isParallel(Line line) {
            return (long)this.a * (long)line.b - (long)this.b * (long)line.a == 0;
        }

        boolean isIntegerPoint(Line line) {
            float x = (float) ((long)this.c * (long)line.a - (long) this.a * (long)line.c) / ((long)this.a * (long)line.b - (long)this.b * (long)line.a);
            float y = (float) ((long)this.b * (long)line.c - (long) this.c * (long)line.b) / ((long)this.a * (long)line.b - (long)this.b * (long)line.a);
            return x == Math.floor(x) && y == Math.floor(y);
        }

        Point getIntersection(Line line) {
            long x = ((long)this.c * (long)line.a - (long) this.a * (long)line.c) / ((long)this.a * (long)line.b - (long)this.b * (long)line.a);
            long y = ((long)this.b * (long)line.c - (long) this.c * (long)line.b) / ((long)this.a * (long)line.b - (long)this.b * (long)line.a);
            return new Point(x, y);
        }
    }

    static class Point {
        long x;
        long y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}