class Solution {
    public String solution(String code) {
        int mode = 0;
        String ret = "";
        char[] charArray = code.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '1') {
                mode = 1 - mode;
            } else if(mode == i%2) {
                ret = ret+charArray[i];
            }
        }
        return ret.length() != 0 ? ret : "EMPTY";
    }
}