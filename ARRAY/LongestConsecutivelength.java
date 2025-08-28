package ARRAY;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutivelength {

    public static int longestConsecutivelength(int nums[]){
        int longest=0;
Set<Integer>set =new HashSet<>();
for(int i:nums){
    set.add(i);
}
for(int i:set){
    if(!set.contains(i-1)){
        int cnt=1;
        int x=i;
        while (set.contains(x+1)) {
            x=x+1;
            cnt=cnt+1;
        }
        longest=Math.max( longest,cnt);
    }
}


        return longest;
    }
    
public static int betterSolution(int []nums){
    Arrays.sort(nums);
          int longest=1,countCurr=0;
          int lastSmaller=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1==lastSmaller){
               countCurr++;
               lastSmaller=nums[i];
            }else if(nums[i]!=lastSmaller){
                countCurr=1;
                lastSmaller=nums[i];
            }
            longest=Math.max(longest,countCurr);
        }
        return longest;
}
    public static void main(String[] args) {
        int nums[]={1,0,1,2};
        System.out.println(longestConsecutivelength(nums));
        System.out.println(betterSolution(nums));
    }
}