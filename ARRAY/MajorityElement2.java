package ARRAY;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        int count1 = 0;
        int count2 = 0;
        Integer el1 = null;
        Integer el2 = null;
        for (int i : nums) {
            if (el1 != null && i == el1) {
                count1++;
            } else if (el2 != null && i == el2) {
                count2++;
            } else if (count1 == 0) {
                el1 = i;
                count1 = 1;
            } else if (count2 == 0) {
                el2 = i;
                count2 = 1;

            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (el1 != null && i == el1) {

                count1++;

            } else if (el2 != null && i == el2) {
                count2++;
            }
        }

        if (count1 > n / 3)
            list.add(el1);
        if (count2 > n / 3)
            list.add(el2);
        return list;
    }

 public static void main(String[] args) {
        int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(arr).toString());
    }
}
