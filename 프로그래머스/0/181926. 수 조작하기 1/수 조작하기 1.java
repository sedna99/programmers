import java.util.function.Function;
import java.util.Map;

class Solution {
    public int solution(int n, String control) {
        int res = n;
        Map<String, Function<Integer, Integer>> functions = Map.of(
            "w", (num) -> num+1,
            "s", (num) -> num-1,
            "d", (num) -> num+10,
            "a", (num) -> num-10
        );
        
        for(Character c : control.toCharArray()) {
            res = functions.get(Character.toString(c)).apply(res);
        }
        return res;
    }
}