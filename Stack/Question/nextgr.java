class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // A hash map to store the next greater element for each number in nums2.
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        
        // A monotonic decreasing stack to find the next greater element.
        Deque<Integer> stack = new ArrayDeque<>();
        
        // Iterate through nums2 to populate the nextGreaterMap.
        for (int num : nums2) {
            // While the stack is not empty and the current number is greater
            // than the top of the stack, we have found the next greater element
            // for the element at the top of the stack.
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            // Push the current number onto the stack.
            stack.push(num);
        }
        
        
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
          
        
            result[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }
        
        return result;
    }
}