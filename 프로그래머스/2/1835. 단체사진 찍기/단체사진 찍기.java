import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, String[] data) {
        List<Character> friends = List.of('A', 'C', 'F', 'J', 'M', 'N', 'R', 'T');
        List<Character> tempList = new ArrayList<>(friends);
        List<String> cases = getCases(new StringBuilder(), tempList, new ArrayList<>());
        for(String row: data) {
            cases = cases.stream().filter(cr -> check(row, cr)).collect(Collectors.toList());
        }
        return cases.size();
    }

    public List<String> getCases(StringBuilder sb, List<Character> charList, List<String> result) {
        if(charList.size() == 0) {
            result.add(sb.toString());
            sb.setLength(sb.length() - 1);
            return result;
        }
        for(Character c : charList) {
            List<Character> tempList = new ArrayList<>(charList);
            tempList.remove(c);
            sb.append(c);
            getCases(sb, tempList, result);
        }
        if(sb.length() != 0){
            sb.setLength(sb.length() - 1);
        }
        return result;
    }

    public boolean check(String row, String caseRow) {
        int fromIdx = caseRow.indexOf(row.charAt(0));
        int toIdx = caseRow.indexOf(row.charAt(2));
        char op = row.charAt(3);
        int rowDiff = Character.getNumericValue(row.charAt(4)) + 1;
        int diff = Math.abs(fromIdx - toIdx);
        if(op == '=') {
            return diff == rowDiff;
        } else if(op == '>') {
            return diff > rowDiff;
        } else {
            return diff < rowDiff;
        }
    }
}