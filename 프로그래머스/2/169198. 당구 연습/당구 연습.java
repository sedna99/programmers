import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        Point startPoint = new Point(startX, startY);
        List<Integer> result = new ArrayList<>();
        for (int[] ball : balls) {
            result.add(getMirrorPoint(startPoint, new Point(ball[0], ball[1]), m, n).stream().mapToInt(startPoint::distanceSqaure).min().getAsInt());
        }
        return result.stream().mapToInt(x -> x).toArray();
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int distanceSqaure(Point p) {
            return (int) Math.pow(x - p.x, 2) + (int) Math.pow(y - p.y, 2);
        }
    }

    List<Point> getMirrorPoint(Point sp, Point p, int m, int n) {
        List<Point> points = new ArrayList<>();
        if (!(sp.y == p.y && sp.x > p.x)) {
            points.add(new Point(-p.x, p.y));
        }
        if (!(sp.x == p.x && sp.y > p.y)) {
            points.add(new Point(p.x, -p.y));
        }
        if (!(sp.y == p.y && sp.x < p.x)) {
            points.add(new Point(p.x + (m - p.x) * 2, p.y));
        }
        if (!(sp.x == p.x && sp.y < p.y)) {
            points.add(new Point(p.x, p.y + (n - p.y) * 2));
        }
        return points;
    }
}