package ARRAY;

public class FindMaxConsecutiveOne {
    public static int findMaxConsecutiveOnes(int[] nums) {
       int maxCount=0;
       int currentCount=0;
       for(int i=0;i<nums.length;i++){
        if(nums[i]==1){
            currentCount++;
            maxCount=Math.max(maxCount,currentCount);
        }else{
            currentCount=0;
        }
       }

       return maxCount;
    }
public static void main(String[] args) {
    int arr[]={1,1,0,1,1,1};
    System.out.println(findMaxConsecutiveOnes(arr));
}
}
