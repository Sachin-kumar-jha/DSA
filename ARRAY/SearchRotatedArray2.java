 package ARRAY;
 
 public class SearchRotatedArray2 {
    public static boolean search(int[] nums, int target) {
        int si = 0, ei = nums.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] == target) {
                return true;
            }
            if (nums[si] == nums[mid] && nums[mid] == nums[ei]) {
                si++;
                ei--;
                continue;
            }

            // Left part is sorted
            if (nums[si] <= nums[mid]) {
                if (nums[si] <= target && target <= nums[mid]) {
                    ei = mid - 1; // search left
                } else {
                    si = mid + 1; // search right
                }
            }
            // Right part is sorted
            else {
                if (nums[mid] <= target && target <= nums[ei]) {
                    si = mid + 1; // search right
                } else {
                    ei = mid - 1; // search left
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int nums[]={2,5,6,0,0,1,2};
        System.out.println(search(nums, 0));
    }
    
 }