public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

    int[] need = new int[128];
    int required = 0;
    for (char c : t.toCharArray()) {
        if (need[c] == 0) required++;
        need[c]++;
    }

    int[] window = new int[128];
    int formed = 0;

    int l = 0, r = 0;
    int minLen = Integer.MAX_VALUE;
    int start = 0;

    while (r < s.length()) {
        char c = s.charAt(r);
        window[c]++;
        if (window[c] == need[c]) formed++;

        while (formed == required) {
            if (r - l + 1 < minLen) {
                minLen = r - l + 1;
                start = l;
            }

            char leftChar = s.charAt(l);
            window[leftChar]--;
            if (window[leftChar] < need[leftChar]) formed--;

            l++;
        }
        r++;
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

}
