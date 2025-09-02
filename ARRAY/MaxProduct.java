
package ARRAY;
public class MaxProduct {
    public static int maxProduct(int[] nums) {
        int pref=1,suff=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(pref==0) pref=1;
            if(suff==0) suff=1;
            pref=pref*nums[i];
            suff=suff*nums[nums.length-i-1];
          max=Math.max(max,Math.max(pref,suff));
        }
        return max;
    }
public static void main(String[] args) {
    int nums[]={2,3,-2,4};
    System.out.println(maxProduct(nums));
}
}
