package ARRAY;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {

 /**
  * 
Time Complexity: O(n)
Space Complexity: O(n)
  */
        Map<Integer,Integer>map=new HashMap<Integer,Integer>();
        map.put(0,1);
        int preSum=0,cnt=0;
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            int remove = preSum-k;
     if(map.containsKey(remove)){
           cnt += map.get(remove);
            
            }
           map.put(preSum, map.getOrDefault(preSum,0)+1);
        }
        return cnt;
    }
    public static void main(String[] args) {
        int []nums={1,-1,0};
        int k=0;
        System.out.println(  subarraySum(nums, k));

    }
}
