import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.stream.Stream;

class Solution {
    public int[] solution(int l, int r) {
        int[] res = IntStream.range(l, r+1).filter(i -> (""+i).chars().mapToObj(c -> c == '0' || c == '5').allMatch(b->b)).toArray();
        return res.length != 0 ? res : new int[] {-1};
    }
}