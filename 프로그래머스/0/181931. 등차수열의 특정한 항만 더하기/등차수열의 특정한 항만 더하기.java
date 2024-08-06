import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int solution(int a, int d, boolean[] included) {
        return IntStream.range(0, included.length).map(idx -> included[idx] ? a+d*idx : 0).sum();
    }
}