import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        Set<Integer> points = new HashSet<>();
        for (int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
            points.add(edge[0]);
            points.add(edge[1]);
        }
        int created = 0;
        int bar = 0;
        int eight = 0;
        for (int point : points) {
            int inValue = in.getOrDefault(point, 0);
            int outValue = out.getOrDefault(point, 0);
            if(outValue > 1 && inValue == 0) {
                created = point;
            }
            if(inValue >= 0 && outValue == 0) {
                bar++;
            }
            if(inValue >= 2 && outValue >= 2) {
                eight++;
            }
        }

        int totalCount = out.get(created);
        return new int[] {created, totalCount - bar - eight, bar, eight};
    }
}