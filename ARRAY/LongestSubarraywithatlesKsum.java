package ARRAY;

import java.util.*;

public class LongestSubarraywithatlesKsum {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }

        int ans = n + 1;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < prefix.length; i++) {
            // condition 1: check if subarray sum >= k
            while (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= k) {
                ans = Math.min(ans, i - dq.pollFirst());
            }
            // condition 2: maintain increasing order of prefix sums
            while (!dq.isEmpty() && prefix[i] <= prefix[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }

        return ans <= n ? ans : -1;
    }

    public static void main(String[] args) {
        int nums[] = {77, 19, 35, 10, -14};
        System.out.println(shortestSubarray(nums, 19)); 
    }
}
