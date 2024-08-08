class Solution {
    public String solution(String new_id) {
        System.out.println(new_id.length());
        return step7(step6(step5(step4(step3(step2(step1(new_id)))))));
    }

    public String step1(String before) {
        return before.toLowerCase();
    }

    public String step2(String before) {
        return before.replaceAll("[^0-9a-z\\-_.]", "");
    }

    public String step3(String before) {
        return before.replaceAll("\\.+", ".");
    }

    public String step4(String before) {
        return before.replaceAll("^[.]|[.]$", "");
    }

    public String step5(String before) {
        return before.isEmpty() ? "a" : before;
    }

    public String step6(String before) {
        return before.length() > 15 ? before.substring(0, 15).replaceAll("\\.$", "") : before;
    }

    public String step7(String before) {
        StringBuilder after = new StringBuilder(before);
        while(after.length() < 3) {
            after.append(after.charAt(after.length() - 1));
        }
        return after.toString();
    }
}