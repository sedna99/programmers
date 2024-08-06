import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] arr) {
        ArrayDeque<Integer> stk = new ArrayDeque<Integer>();
        int i = 0;
        for(Integer num : arr){
            while(i < arr.length) {
                if(stk.size() == 0 || stk.peekLast() < arr[i]) {
                    stk.addLast(arr[i]);
                    i++;
                    continue;
                }
                else if(stk.peekLast() >= arr[i]) {
                    stk.pollLast();
                }
            }            
        }
        
        return stk.stream().mapToInt(j -> j).toArray();
    }
}