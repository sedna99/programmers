import java.util.stream.IntStream;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] curr = new int[2];
        boolean[][] map = new boolean[park.length][park[0].length()];
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    curr[0] = i;
                    curr[1] = j;
                    map[i][j] = true;
                } else map[i][j] = park[i].charAt(j) == 'O';
            }
        }
        
        for(String route : routes) {
            String[] split = route.split(" ");
            curr = move(map, curr, split[0], split[1]);
        }
        return curr;
    }

    public int[] move(boolean[][] map, int[] curr, String direction, String amount) {
        int x = curr[0];
        int y = curr[1];
        int nextX = curr[0];
        int nextY = curr[1];
        int temporalX = x;
        int temporalY = y;
        int parsedAmount = Integer.parseInt(amount);
        switch(direction) {
            case "N":
                temporalX -= parsedAmount;
                if(canMove(map, x, y, temporalX, nextY)) nextX = temporalX;
                break;
            case "S":
                temporalX += parsedAmount;
                if(canMove(map, x, y, temporalX, nextY)) nextX = temporalX;
                break;
            case "W":
                temporalY -= parsedAmount;
                if(canMove(map, x, y, nextX, temporalY)) nextY = temporalY;
                break;
            case "E":
                temporalY += parsedAmount;
                if(canMove(map, x, y, nextX, temporalY)) nextY = temporalY;
                break;
        }
        return new int[] {nextX, nextY};
    }

    public boolean canMove(boolean[][] map, int x, int y, int temporalX, int temporalY) {
        if((temporalX < 0) || (temporalX > map.length - 1) || temporalY < 0  || temporalY > (map[0].length - 1)) return false;
        boolean xFlag = x <= temporalX;
        boolean yFlag = y <= temporalY;
        return (!IntStream.range(xFlag ? x : temporalX, xFlag ? temporalX+1: x+1).mapToObj(i -> map[i][y]).anyMatch(b -> b == false)) && (!IntStream.range(yFlag ? y : temporalY, yFlag ? temporalY+1 : y+1).mapToObj(i -> map[x][i]).anyMatch(b -> b == false));
    }
}