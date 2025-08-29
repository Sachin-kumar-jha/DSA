package ARRAY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

    public static List<List<Integer>> forSum(int nums[], int target) {
        int n = nums.length;
        Set<List<Integer>> ls = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int fourth = target - sum;
                    if (set.contains(fourth)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(fourth);
                        Collections.sort(list);
                        ls.add(list);

                    }
                    set.add(nums[k]);
                }
            }
        }
        return new ArrayList<>(ls);
    }

    public static List<List<Integer>> optimalSolution(int nums[], int target) {
        Arrays.sort(nums);
        Set<List<Integer>> ls = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                     
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        ls.add(list);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k + 1])
                            k++;
                        // skip duplicates for l
                        while (k < l && nums[l] == nums[l - 1])
                            l--;
                    }
                }
            }
        }
        return new ArrayList<>(ls);
    }

    public static void main(String[] args) {
        int nums[] = {-1,0,-5,-2,-2,-4,0,1,-2};
        System.err.println(forSum(nums, -9));
        System.out.println(optimalSolution(nums, -9));
    }
}
