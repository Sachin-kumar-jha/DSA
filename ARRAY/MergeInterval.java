package ARRAY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static int[][] merge(int[][] intervals) {
      Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            
           
            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);

        return result.toArray(new int[result.size()][]);
       
    }
public static void main(String[] args) {
 int arr[][]={{1,3},{2,6},{8,10},{15,18}};
    int [][]nums=merge(arr);

    for(int i=0;i<nums.length;i++){
        for(int j=0;j<nums[0].length;j++){
            System.out.print(nums[i][j]+" ");
        }
         System.out.println();
    }

}
}
