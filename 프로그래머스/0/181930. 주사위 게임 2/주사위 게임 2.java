import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c) {
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(a,b,c));
        int result = 1;
        for(int i = 0; i < 4 - set.size(); i++){
            result=result*((int)Math.pow(a,i+1) + (int)Math.pow(b,i+1) + (int)Math.pow(c,i+1));
        }
        return result;
    }
}