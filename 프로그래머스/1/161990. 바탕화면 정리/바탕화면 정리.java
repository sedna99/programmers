class Solution {
    public int[] solution(String[] wallpaper) {
        boolean[][] tfMap = new boolean[wallpaper.length][wallpaper[0].length()];
        int minI = wallpaper.length - 1;
        int minJ = wallpaper[0].length() - 1;
        int maxI = 0;
        int maxJ = 0;
        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[0].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    tfMap[i][j] = true;
                    if(i < minI) minI = i;
                    if(j < minJ) minJ = j;
                    if(i > maxI) maxI = i;
                    if(j > maxJ) maxJ = j;
                };
            }
        }
        return new int[] {minI, minJ, maxI + 1, maxJ + 1};
    }
}