
/**
 * Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

A good subarray is a subarray where:

its length is at least two, and
the sum of the elements of the subarray is a multiple of k.
Note that:

A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 * 
 */

 package ARRAY;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
 public static boolean checkSubarraySum(int[] nums, int k) {
        // map remainder -> first index where it occurred
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(0, -1);  
        int preSum = 0;
        //Here we are storing remainder and index in hashmap
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int remainder = k == 0 ? preSum : preSum % k;

            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                // store only the first occurrence
                map.put(remainder, i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int nums[]={23,2,4,6,7};
        int k =6;
        System.out.println(checkSubarraySum(nums, k));
    }
 }