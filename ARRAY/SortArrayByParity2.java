package ARRAY;

public class SortArrayByParity2 {
   public int[] sortArrayByParityII(int[] nums) {
        int arr[]=new int[nums.length];
        int evenIdx=0;int oddIdx=1;
        for(int i:nums){
            if(i%2==0){
                arr[evenIdx]=i;
                evenIdx+=2;
            }else{
                arr[oddIdx]=i;
                oddIdx+=2;
            }
        }
        return arr;
    }
}
