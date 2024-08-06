import java.lang.Integer;

class Solution {
    public int solution(int a, int b) {
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);
        int ab = Integer.parseInt(strA + strB);
        int ba = Integer.parseInt(strB + strA);
        return ab >= ba ? ab : ba;
    }
}