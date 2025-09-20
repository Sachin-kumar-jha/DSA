package String;

class MaxDepthString {
    public static int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] answer = new int[n];
        int depth = 0;

        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                answer[i] = depth % 2;  // assign before incrementing
                depth++;
            } else { // ')'
                depth--;
                answer[i] = depth % 2;  // assign after decrementing
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "()(())()";
        int[] arr = maxDepthAfterSplit(s);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
