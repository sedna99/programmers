import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int friendsLength = friends.length;
        HashMap<String, Integer> friendsMap = new HashMap<String, Integer>();
        
        for(int i = 0; i < friendsLength; i++) {
            friendsMap.put(friends[i], i);
        }
        
        int[][] giftGraph = new int[friendsLength][friendsLength];
        
        for(int i = 0; i < gifts.length; i++) {
            String[] giftRow = gifts[i].split(" ");
            giftGraph[friendsMap.get(giftRow[0])][friendsMap.get(giftRow[1])]++;
        }
        
        int[] giftDegree = new int[friendsLength];
        
        for(int i=0; i<friendsLength; i++) {
            int give = 0;
            int take = 0;
            for(int j=0; j<friendsLength; j++ ){
                give = give + giftGraph[i][j];
                take = take + giftGraph[j][i];
            }
            giftDegree[i] = give - take;
        }
        
        int[] giftCounts = new int[friendsLength];
        for(int i=0; i<friendsLength; i++) {
            for(int j = 0; j < friendsLength; j++){
                if(giftGraph[i][j] > giftGraph[j][i]) giftCounts[i]++;
                else if((giftGraph[j][i] == giftGraph[i][j]) && (giftDegree[i] > giftDegree[j])) giftCounts[i]++;
            }
        }
        return Arrays.stream(giftCounts).boxed().max(Integer::compare).get();
    }
}