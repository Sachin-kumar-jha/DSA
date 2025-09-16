package String;

public class LargetOddNumberinString {
public static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            char ch = num.charAt(i);
            int digit = ch - '0';
            if (digit % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
    
    public static void main(String[] args) {
        String st= "3542";
        System.out.println(largestOddNumber(st));
    }
}