import java.util.HashMap;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int idsCount = id_list.length;
        HashMap<String, Integer> indexMap = new HashMap();
        for(int i = 0; i < id_list.length; i++) {
            indexMap.put(id_list[i], i);
        }

        int[][] reportGraph = new int[idsCount][idsCount];

        for(int i = 0; i < report.length; i++) {
            String[] splitted = report[i].split(" ");
            int from = indexMap.get(splitted[0]);
            int to = indexMap.get(splitted[1]);
            reportGraph[from][to] = 1;
        }

        boolean[] blockArr = new boolean[idsCount];

        for(int j = 0; j < idsCount; j++) {
            int reportCount = 0;
            for(int i = 0; i < idsCount; i++ ){
                if(reportGraph[i][j] == 1) reportCount++;
            }
            if(reportCount >= k) blockArr[j] = true;
        }

        int[] mailArr = new int[idsCount];

        for(int j = 0; j < idsCount; j++) {
            if(blockArr[j]) {
                for(int i = 0; i < idsCount; i++) {
                    if(reportGraph[i][j] == 1) mailArr[i]++;
                }
            }
        }

        return mailArr;
    }
}