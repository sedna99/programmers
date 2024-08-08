import java.util.ArrayDeque;

class Solution {
    public int solution(int[][] board, int[] moves) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for(int move: moves) {
            int next = 0;
            for(int j = 0; j < board.length; j++) {
                next = board[j][move-1];
                if(next > 0) {
                    board[j][move-1] = 0;
                    if(stack.isEmpty() || (stack.peekLast() != next)) stack.addLast(next);
                    else {
                        stack.removeLast();
                        result+=2;
                    }
                    break;
                }
            }
        }
        return result;
    }
}