package ARRAY;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArray {
 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Size of two given arrays
        int n1 = nums1.length;
        int n2 = nums2.length;

        List<Integer> arr3 = new ArrayList<>();
        // Apply the merge step
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                arr3.add(nums1[i++]);
            } else {
                arr3.add(nums2[j++]);
            }
        }

        // Copy the left-out elements
        while (i < n1) {
            arr3.add(nums1[i++]);
        }
        while (j < n2) {
            arr3.add(nums2[j++]);
        }

        // Find the median
        int n = n1 + n2;
        if (n % 2 == 1) {
            return (double) arr3.get(n / 2);
        }

        double median = ((double) arr3.get(n / 2) + (double) arr3.get((n / 2) - 1)) / 2.0;
        return median;
    }
    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays is " + findMedianSortedArrays(a, b));
    }
}