import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        if(a.length() < 1) {
            System.out.println("str의 길이가 1 이상이어야 합니다.");
        } else if(a.length() > 1000000){
            System.out.println("str의 길이가 100만 이하여야 합니다.");
        } else {
            System.out.println(a);   
        }
    }
}