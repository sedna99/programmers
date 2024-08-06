import java.util.stream.IntStream;
class Solution {
    public int solution(int n) {
        return IntStream.range(1, n+1).filter(a -> a%2 == n%2).map(b->(b%2==0 ? b*b : b)).sum();
    }
}