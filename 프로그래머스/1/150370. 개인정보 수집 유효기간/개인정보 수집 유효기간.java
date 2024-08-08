import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termsMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        MyDate todayDate = new MyDate(today);

        for(String term : terms) {
            String[] split = term.split(" ");
            termsMap.put(split[0], Integer.parseInt(split[1]));
        }

        for(int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            MyDate limitDate = new MyDate(split[0]).addMonth(termsMap.get(split[1])).minusDay(1);
            if(todayDate.isAfter(limitDate)) result.add(i+1);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
    class MyDate {
        int year;
        int month;
        int day;

        public MyDate(String date) {
            int[] split = Arrays.stream(date.split("\\.")).mapToInt(Integer::valueOf).toArray();
            this.year = split[0];
            this.month = split[1];
            this.day = split[2];
        }

        public MyDate addMonth(int m) {
            month += m;
            while(month > 12) {
                month -= 12;
                year++;
            }
            return this;
        }

        public MyDate minusDay(int d) {
            day -= d;
            if(day <= 0) {
                month--;
                day+=+28;
                if(month <= 0) {
                    year--;
                    month+=12;
                }
            }
            return this;
        }

        public boolean isAfter(MyDate other) {
            return this.year * 10000 + this.month * 100 + this.day > other.year * 10000 + other.month * 100 + other.day;
        }
    }
}
