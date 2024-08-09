import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
     public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> keyMap = new HashMap<>();
        keyMap.put("code", 0);
        keyMap.put("date", 1);
        keyMap.put("maximum", 2);
        keyMap.put("remain", 3);
        List<List<Integer>> resultList = new ArrayList<>();
        int sortIndex = keyMap.get(sort_by);
        int compareIndex = keyMap.get(ext);
        return Arrays.stream(data).filter(row -> row[compareIndex] < val_ext).sorted(Comparator.comparingInt(a -> a[sortIndex])).toArray(int[][]::new);
    }
}