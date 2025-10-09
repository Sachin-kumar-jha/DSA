package Recursion.Question;

public class FindSubsets {

   public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // Sort the array to handle duplicates efficiently.
        Arrays.sort(nums);
        findSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void findSubsets(int ind, int[] nums, List<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list)); // Add a copy of the current subset

        for (int i = ind; i < nums.length; i++) {
            // Skip duplicates. If the current element is the same as the previous
            // one, it will generate a duplicate subset.
            if (i > ind && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include the current element
            list.add(nums[i]);
            
            // Recurse with the next index
            findSubsets(i + 1, nums, list, ans);
            
            // Backtrack: Remove the element to explore other possibilities
            list.remove(list.size() - 1);
        }
    }
}