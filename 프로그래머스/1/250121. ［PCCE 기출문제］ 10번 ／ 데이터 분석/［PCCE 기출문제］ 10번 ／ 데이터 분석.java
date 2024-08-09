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
        for (int i = 0; i < data.length; i++) {
            int[] row = data[i];
            int index = keyMap.get(ext);
            if(row[index] < val_ext) {
                resultList.add(IntStream.of(row).boxed().collect(Collectors.toList()));
            };
        }
        return resultList.stream().sorted((a, b) -> a.get(sortIndex) - b.get(sortIndex)).map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}