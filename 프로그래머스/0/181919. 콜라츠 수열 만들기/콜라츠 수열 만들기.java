import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(n);
        while(n != 1) {
        switch (n%2) {
            case 0:
                n=n/2;
                break;
            case 1:
                n=3*n+1;
                break;
        }
            list.add(n);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}