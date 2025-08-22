package ARRAY;

public class PartitionAccToPivot {
   
    public int[] pivotArray(int[] nums, int pivot) {
  
    /**
    brute force:
    TCL=O(n)
    SCL=O(n)
Here in this problem Stable table order required → so extra array (O(n), O(n) space).
    **/
    int arr[]=new int[nums.length];
      int idx=0;

       for(int i:nums){
        if(i<pivot){
            arr[idx++]=i;
        }
       }

       for(int i:nums){
        if(i==pivot){
            arr[idx++]=i;
        }
       }

       for(int i:nums){
        if(i>pivot){
            arr[idx++]=i;
        }
       }
       return arr;
    
    //  return partitonByPivot(nums,pivot,0,nums.length);
    }


/**

if Order doesn’t matter → Use QuickSort partitioning (O(n), O(1) space).
Then this code:
 public int[] partitonByPivot(int[]nums,int pivot,int si,int ei){

       int i=si;
       for(int j=si;j<ei;j++){
        if(nums[j] <= pivot){
            int temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
            i++;
        }
       }
      
      int left=0;
      for(int right=0;right<i;right++){
        if(nums[right] < pivot){
            int temp =nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
        }
      }
         
       return nums;
    }
 */
   
}

