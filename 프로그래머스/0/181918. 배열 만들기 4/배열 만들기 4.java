import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] arr) {
        ArrayDeque<Integer> stk = new ArrayDeque<Integer>();
        for(Integer num : arr){
            while(stk.size() != 0 && stk.peekLast() >= num) {
                 stk.pollLast();   
            }
            stk.addLast(num);
        }
        return stk.stream().mapToInt(j -> j).toArray();
    }
}