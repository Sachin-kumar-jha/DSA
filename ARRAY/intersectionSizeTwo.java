// import java.util.Arrays;
// import java.util.Comparator;

// class Solution {
//     public int intersectionSizeTwo(int[][] intervals) {
//         // Sort intervals based on their end point
//         Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

//         // max1 and max2 will store the two largest points chosen so far.
//         // Initialize them to -1 as placeholders to indicate no points have been chosen yet.
//         int max1 = -1;
//         int max2 = -1;
//         int count = 0;

//         for (int[] interval : intervals) {
//             int start = interval[0];
//             int end = interval[1];

//             // Check how many of the currently selected points (max1, max2) fall within this interval.
//             boolean hasMax1 = (max1 != -1 && max1 >= start && max1 <= end);
//             boolean hasMax2 = (max2 != -1 && max2 >= start && max2 <= end);

//             if (hasMax1 && hasMax2) {
//                 // If both max1 and max2 are in the current interval, we are good.
//                 continue;
//             } else if (hasMax1 || hasMax2) {
//                 count++;
//                 if (hasMax1) {
//                     max2 = end; 
//                 } else {
//                     max1 = end;
//                 }
//             } else {
//                 count += 2;
//                 max1 = end;
//                 max2 = end - 1; // Make sure max1 is always the actual largest value
//             }
//             if (max1 < max2) {
//                 int temp = max1;
//                 max1 = max2;
//                 max2 = temp;
//             }
//         }
//         return count;
//     }
// }

import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

class intersectionSizeTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        // Sort intervals based on their end point ascending, then start point descending
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1]; // Ascending end point
            }
            return b[0] - a[0]; // Descending start point for same end points
        });

        // Use a list to store the optimal set of points added so far.
        List<Integer> points = new ArrayList<>();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int size = points.size();

            // Count how many of our existing points fall within the current interval
            int coverage = 0;
            if (size >= 1 && points.get(size - 1) >= start && points.get(size - 1) <= end) {
                coverage++;
            }
            if (size >= 2 && points.get(size - 2) >= start && points.get(size - 2) <= end) {
                coverage++;
            }

            if (coverage == 2) {
                // Interval is already fully covered by the last two best points
                continue;
            } else if (coverage == 1) {
                // Only one point covered, add the second needed point: the end point.
                points.add(end);
            } else {
                // Zero points covered, add two points: the end point and (end - 1).
                points.add(end - 1);
                points.add(end);
            }
        }
        
        // The total number of unique points added to the list is the minimum size.
        // Since we are always adding the two largest points per requirement, 
        // the size of the list is the answer.
        return points.size();
    }
}
