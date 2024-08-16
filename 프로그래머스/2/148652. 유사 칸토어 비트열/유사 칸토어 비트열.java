class Solution {
    public int solution(int n, long l, long r) {
        int count = 0;
        for(long i = l-1; i < r; i++) {
            if(isOne(i)) count++;
        }
        return count;
    }

    public boolean isOne(long val) {
        while(val > 5) {
            if(val % 5 == 2) {
                return false;
            }
            val = val / 5;
        }
        return val != 2;
    }
}