package ARRAY;

import java.util.Arrays;

public class ClosetSum {

     public static int threeSumClosest(int[] nums, int target) {
         Arrays.sort(nums);
      int closestSum=nums[0]+nums[1]+nums[nums.length-1];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(Math.abs(sum - target) < Math.abs(closestSum - target)){
                    closestSum=sum;
                }else if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else{
                    return sum;
                }
                }
            }
            return closestSum;
        }
        
public static void main(String[] args) {
    int arr[]={-1,2,1,-4};
    int target=1;
    System.out.println(threeSumClosest(arr, target));
}
    }
    
