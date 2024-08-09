class Solution {
    public int solution(String s) {
        int count = 0;
        while(!s.isEmpty()){
            char x = s.charAt(0);
            int xCount = 1;
            int otherCount = 0;
            while(xCount > otherCount) {
                if(xCount + otherCount >= s.length()) {
                    break;
                }
                else if(x == s.charAt(xCount+otherCount)){
                    xCount++;
                } else {
                    otherCount++;
                }
            }
            s = s.substring(xCount+otherCount);
            count ++;
        }
        return count;
    }
}