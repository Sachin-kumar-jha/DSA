package ARRAY;

public class RearrangeBySign {
    
    public int[] rearrangeArray(int[] nums) {
        int arr[]=new int[nums.length];
      int evenIdx=0 ,oddIdx=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                arr[evenIdx]=nums[i];
                evenIdx+=2;
            }else{
                arr[oddIdx]=nums[i];
                oddIdx+=2;
            }
        }
        return arr;
    }

}
