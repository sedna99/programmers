import java.util.stream.IntStream;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numLog) {
        Map<Integer, Function<Void, String>> functions = Map.of(
            1, (Void v) -> "w",
            -1, (Void v) -> "s",
            10, (Void v) -> "d",
            -10, (Void v) -> "a"
        );
        return IntStream.range(0, numLog.length - 1).mapToObj((i)->functions.get(numLog[i+1]-numLog[i]).apply(null)).collect(Collectors.joining());
    }
}