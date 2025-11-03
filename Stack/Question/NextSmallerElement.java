package Stack.Question;
import java.util.*;
public class NextSmallerElement {
    // Function to find the next smaller elements
    public int[] nextSmallerElement(int[] arr) {
        int n = arr.length;

        // Initialize the answer array with -1
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        // Traverse each element in the array
        for (int i = 0; i < n; i++) {
            int curr = arr[i];

            // Look ahead to find the next smaller element
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < curr) {
                    // Store and break on finding the smaller element
                    ans[i] = arr[j];
                    break;
                }
            }
        }

        // Return the answer array
        return ans;
    }

}