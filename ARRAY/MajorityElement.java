package ARRAY;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        /*
         * Brute force
         * int count;
         * for(int i:nums){
         * count=0;
         * for(int j=0;j<nums.length;j++){
         * if(i==nums[j]){
         * count++;
         * }
         * }
         * if(count > nums.length/2){
         * return i;
         * }
         * }
         * return -1;
         * 
         * 
         * Better Solution
         * Map<Integer,Integer> hs = new HashMap<>();
         * 
         * for(int i =0;i<nums.length;i++){
         * hs.put(nums[i],i++);
         * }
         * for(int k : hs.keySet()){
         * if(hs.get(k)>nums.length/2){
         * return k;
         * }
         * }
         * return -1;
         */

        // Optimal solution using moore's algo
        int count = 0;
        int el = 0;
        for (int i : nums) {
            if (count == 0) {
                count = 1;
                el = i;
            } else if (i == el) {
                count++;
            } else {
                count--;
            }
        }

        int cnt1 = 0;
        for (int i : nums) {
            if (i == el)
                cnt1++;
        }
        if (cnt1 > nums.length / 2) {
            return el;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(arr));
    }
}

