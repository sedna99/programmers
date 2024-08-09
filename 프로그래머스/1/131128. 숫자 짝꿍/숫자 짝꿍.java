import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public String solution(String X, String Y) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> resultList = new ArrayList<>();
        for(char charX : X.toCharArray()) {
            map.put(charX, map.getOrDefault(charX, 0) + 1);
        }
        for(char charY : Y.toCharArray()) {
            int count = map.getOrDefault(charY, 0);
            if(count > 0) {
                map.put(charY, count - 1);
                resultList.add(charY);
            }
        }
        return resultList.isEmpty() ? "-1" : resultList.stream().sorted((a, b) -> b - a).map(String::valueOf).collect(Collectors.joining()).replaceAll("^[0]+$", "0");
    }
}