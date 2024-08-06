import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int last = num_list[num_list.length-1];
        int lastIdx = num_list.length - 1;
        int nextLast = num_list[lastIdx] > num_list[lastIdx - 1] ? num_list[lastIdx] - num_list[lastIdx - 1] : 2*num_list[lastIdx];
        int[] result = Arrays.copyOf(num_list, num_list.length + 1);
        result[lastIdx + 1] = nextLast;
        return result;
    }
}