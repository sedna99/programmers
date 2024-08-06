import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] num_list) {
        String oddStr = Arrays.stream(num_list).filter(a-> a%2 == 0).mapToObj(a->""+a).collect(Collectors.joining());
        String evenStr = Arrays.stream(num_list).filter(a-> a%2 == 1).mapToObj(a->""+a).collect(Collectors.joining());
        return Integer.parseInt(oddStr) + Integer.parseInt(evenStr);
    }
}