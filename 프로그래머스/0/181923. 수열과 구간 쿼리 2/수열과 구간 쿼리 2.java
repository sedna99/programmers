import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        return Arrays.stream(queries).mapToInt(q -> Arrays.stream(arr, q[0], q[1]+1).boxed().filter(a -> (a > q[2])).min(Integer::compare).orElse(-1)).toArray();
    }
}