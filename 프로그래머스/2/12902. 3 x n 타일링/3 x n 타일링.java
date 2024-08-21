class Solution {
    public int solution(int n) {
        long [] dpArr = new long[n + 1];
        dpArr[0] = 1;
        dpArr[2] = 3;
        for (int i = 4; i <= n; i += 2) {
            dpArr[i] = dpArr[i - 2] * 3;
            for(int j = 4; j <= i; j += 2) {
                dpArr[i] += (dpArr[i - j] * 2);
            }
            dpArr[i] %= 1000000007;
        }
        return (int) dpArr[n];
    }
}