import java.util.ArrayDeque;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long distance = 0;
        ArrayDeque<Integer> deliveriesStack = new ArrayDeque<>();
        ArrayDeque<Integer> pickupsStack = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < deliveries[i]; j++) {
                deliveriesStack.push(i + 1);
            }
            for(int j = 0; j < pickups[i]; j++) {
                pickupsStack.push(i + 1);
            }
        }
        while(!(deliveriesStack.size() == 0 && pickupsStack.size() == 0)) {
            int delivery = 0;
            if(deliveriesStack.size() > 0) {
                delivery = deliveriesStack.pop();
                for(int i = 1; i < cap; i++) {
                    if(deliveriesStack.size() != 0) deliveriesStack.pop();    
                }
            }
            int pickup = 0;
            if(pickupsStack.size() > 0) {
                pickup = pickupsStack.pop();
                for(int i = 1; i < cap; i++) {
                    if(pickupsStack.size() != 0) pickupsStack.pop();
                }
            }
            distance = distance + Math.max(delivery, pickup)*2;
        }
        return distance;
    }
}