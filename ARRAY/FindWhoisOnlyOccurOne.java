package ARRAY;

import java.util.HashMap;
import java.util.Map;
//THis is also solve with Xor without extra space of map
public class FindWhoisOnlyOccurOne {
        public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                return nums[i];
            }
        }
        return 0;
    }
public static void main(String[] args) {
    int arr[]={2,2,1};
    System.out.println(singleNumber(arr));
}
}
