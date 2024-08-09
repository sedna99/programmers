import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        ArrayList<Integer> stack = new ArrayList<>();
        int count = 0;
        for (int k : ingredient) {
            stack.add(k);
            int size = stack.size();
            if (size > 3) {
                if (stack.get(size - 1) == 1 && stack.get(size - 2) == 3 && stack.get(size - 3) == 2 && stack.get(size - 4) == 1) {
                    for (int j = 0; j < 4; j++) {
                        stack.remove(stack.size() - 1);
                    }
                    count++;
                }
            }
        }
        return count;
    }
}