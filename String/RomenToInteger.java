package String;

public class RomenToInteger {
    // public int romanToInt(String s) {
    //     // Roman numeral values
    //     Map<Character, Integer> map = new HashMap<>();
    //     map.put('I', 1);
    //     map.put('V', 5);
    //     map.put('X', 10);
    //     map.put('L', 50);
    //     map.put('C', 100);
    //     map.put('D', 500);
    //     map.put('M', 1000);

    //     int total = 0;

    //     for (int i = 0; i < s.length(); i++) {
    //         int value = map.get(s.charAt(i));

    //         // Look ahead: if current < next, subtract it

    //         if (i + 1 < s.length() && value < map.get(s.charAt(i + 1))) {
    //             total -= value;
    //         } else {
    //             total += value;
    //         }
    //     }

    //     return total;
    // }

    
public static int romanToInt(String s) {
        int total=0;
        int prev=0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = getValue(s.charAt(i));

            if (curr < prev) {
                total -= curr; 
            } else {
                total += curr;
            }

            prev = curr;
        }

        return total;
    }

    // Helper function to return value of Roman numeral
    private static int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        String s="III";
        System.out.println(romanToInt(s));
    }
}
