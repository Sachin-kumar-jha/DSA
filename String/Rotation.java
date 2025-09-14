package String;

public class Rotation {
    public static boolean rotateString(String s, String goal) {
        // Condition 1: lengths must match
        if (s.length() != goal.length()) {
            return false;
        }
        // Condition 2: goal must be a substring of s+s
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {
        String s = "abcde", goal = "abced";
        System.out.println(rotateString(s, goal)); // false

        String s2 = "abcde", goal2 = "cdeab";
        System.out.println(rotateString(s2, goal2)); // true
    }
}
