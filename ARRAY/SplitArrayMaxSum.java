
package ARRAY;

public class SplitArrayMaxSum {
 public static int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int w : nums) {
            high += w;
            low = Math.max(low, w);
        }

        /** Brute force */
        // for(int i=low;i<high;i++){
        //     int countSplit=CountSplit(nums,i,k);
        //     if(countSplit==k){
        //         return i;
        //     }
        // }
        
        /**Using Binary search */
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (CountSplit(nums, mid, k) <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int CountSplit(int arr[], int val, int noOfsarr) {
        int countsplit = 1;
        int valueOfindex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (valueOfindex + arr[i] <= val) {
                valueOfindex += arr[i];
            } else {
                countsplit++;
                valueOfindex = arr[i];
            }
        }
        return countsplit;
    }

public static void main(String[] args) {
    int nums[]={7,2,5,10,8};
    int k=2;
    System.out.println(splitArray(nums, k));
}
    
}


   