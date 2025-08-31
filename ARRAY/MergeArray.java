package ARRAY;

import java.util.Arrays;
import java.util.List;

public class MergeArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
          int left=0,right=0,index=0;

          int arr[]=new int[n+m];
          while (left<n && right<m) {
            if (nums1[left]<=nums2[right]) arr[index++]=nums1[left++];
            else arr[index++]=nums2[right++];
          }
          while (left<n) {
            arr[index++]=nums1[left++];
          }
          while (right<m) {
            arr[index++]=nums2[right++];
          }

      for(int i=0;i<m+n;i++){
            nums1[i]=arr[i];
          }

        //   for(int i:arr){
        //     System.out.print(i+" ");
        //   }
    }

    public static void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;       // last real element in nums1
    int j = n - 1;       // last element in nums2
    int k = m + n - 1;   // last position in nums1

    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k--] = nums1[i--];
        } else {
            nums1[k--] = nums2[j--];
        }
    }

    // Copy leftover nums2 elements
    while (j >= 0) {
        nums1[k--] = nums2[j--];
    }
}

    public static void main(String[] args) {
        int nums1[]={1,2,3,0,0,0};
        int nums2[]={2,5,6};
        int n=3;
        int m=3;

      mergeOptimal(nums1, m, nums2, n);
for(int i:nums1){
    System.out.print(i+" ");
}
// for(int i:nums2){
//     System.out.print(i+" ");
// }
    }
}
