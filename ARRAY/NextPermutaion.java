package ARRAY;
class NextPermutaion {
    public static void nextPermutation(int[] nums) {
      int idx=-1;
      int n=nums.length;
      //Finding breakPoint 
      for(int i=n-2;i>=0;i--){
        if(nums[i]<nums[i+1]){
            idx=i;
            break;
        }
      }
//Edge case if your array is descending order then next permutaion is simple reverse the array
 
 if(idx==-1){
   reverse(nums,0,n-1);
 }

 // Find greater but nearest to nums[idx] element

 for(int i=n-1; i > idx; i--){
    if(nums[i] > nums[idx]){
    int temp = nums[i];
    nums[i] = nums[idx];
    nums[idx] = temp;
    }
 }

 //After that other element simply reverse to build smallest part
 reverse(nums,idx+1,n-1);
    }

 public static void swap(int[] arr, int index1, int index2) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
}



public static void reverse(int[] arr,int start,int end) {
    while (start < end) {
        // Swap elements at start and end
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        // Move pointers inwards
        start++;
        end--;
    }
}
 
public static void main(String[] args) {
    int nums[]={1,1,3};
    nextPermutation(nums);
    for(int i:nums){
        System.out.print(i+" ");
    }

}
}
