import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        int allMultiple = Arrays.stream(num_list).reduce(1, (a, b) -> a*b);
        int sumPow = (int)Math.pow(Arrays.stream(num_list).sum(),2);
        return allMultiple < sumPow ? 1 : 0;
    }
}