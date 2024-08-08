import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        char[][] typeArr = new char[][] {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        HashMap<Character, Integer> scoreMap = new HashMap<>();
        for(int i = 0; i < survey.length; i++) {
            System.out.println(survey[i].charAt(choices[i]/4));
            System.out.println(scoreMap.getOrDefault(survey[i].charAt(choices[i]/4), 0) + Math.abs(choices[i]-4));
            scoreMap.put(survey[i].charAt(choices[i]/4), scoreMap.getOrDefault(survey[i].charAt(choices[i]/4), 0) + Math.abs(choices[i]-4));
        }
        char[] charArr = new char[4];
        for(int i = 0; i < typeArr.length; i++) {
            charArr[i] = scoreMap.getOrDefault(typeArr[i][0], 0) >= scoreMap.getOrDefault(typeArr[i][1], 0) ? typeArr[i][0] : typeArr[i][1];
        }
        return String.valueOf(charArr);
    }
}