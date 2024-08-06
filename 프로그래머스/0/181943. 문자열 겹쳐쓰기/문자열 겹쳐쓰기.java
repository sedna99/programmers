class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String before = my_string.substring(0, s);
        String after = my_string.substring(s + overwrite_string.length());
        StringBuilder sb = new StringBuilder();
        sb.append(before).append(overwrite_string).append(after);
        return sb.toString();
    }
}