import java.util.HashMap;
import java.util.stream.Stream;

class Solution {
    public int solution(int a, int b, int c, int d) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);
        int result = 0;
        switch(map.size()){
            case 4:
                result = Stream.of(a, b, c, d).min(Integer::compare).get();
                break;
            case 3:
                result = map.entrySet().stream().filter(e -> e.getValue() == 1).mapToInt(e->e.getKey()).reduce(1, (sum, e) -> sum*e);
                break;
            case 2:
                if(map.containsValue(3)) {
                    int[] temp = map.entrySet().stream().sorted((e, f)->Integer.compare(f.getValue(), e.getValue())).mapToInt(e -> e.getKey()).toArray();
                    result = (int)Math.pow(temp[0]*10 + temp[1], 2);
                } else {
                    int[] temp = map.keySet().stream().mapToInt(i -> i).toArray();
                    result = (temp[0] + temp[1])*Math.abs(temp[0] - temp[1]);
                };
                break;
            case 1:
                result = 1111*a;
                break;
        }
        return result;
    }
}