import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        Arrays
            .stream(queries)
            .forEach(q -> 
                     IntStream
                     .range(q[0], q[1]+1)
                     .forEach(i -> {
                         if(i%q[2] == 0) arr[i]++;
                     }));
        return arr;
    }
}