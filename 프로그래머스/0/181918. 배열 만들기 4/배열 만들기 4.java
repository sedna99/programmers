import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<Integer>();
        int i = 0;
        while(i < arr.length) {
            if(stk.size() == 0 || stk.get(stk.size() - 1) < arr[i]) {
                stk.add(arr[i]);
                i++;
                continue;
            }
            else if(stk.get(stk.size() - 1) >= arr[i]) {
                stk.remove(stk.size() - 1);
            }
        }
        return stk.stream().mapToInt(j -> j).toArray();
    }
}