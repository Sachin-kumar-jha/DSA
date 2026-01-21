import java.util.*;

public class StreamPractice3 {

    public static void main(String[] args) {

        // 1. Find Top 3 Highest Numbers
        // Expected: [90, 80, 70]
        List<Integer> nums1 = Arrays.asList(40, 90, 10, 80, 70, 60);

        // Your Stream code here


        // 2. Find Average of Numbers Greater Than 50
        // Expected: 80.0
        List<Integer> nums2 = Arrays.asList(40, 60, 80, 100, 20);

        // Your Stream code here


        // 3. Convert List of Strings to Map (String -> Length)
        // Expected: {Java=4, Stream=6, API=3}
        List<String> words1 = Arrays.asList("Java", "Stream", "API");

        // Your Stream code here


        // 4. Find Duplicate Elements
        // Expected: [2, 3]
        List<Integer> nums3 = Arrays.asList(1, 2, 2, 3, 3, 4, 5);

        // Your Stream code here


        // 5. Sort Map by Values (Ascending)
        // Expected order: {B=10, A=20, C=30}
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 20);
        map1.put("B", 10);
        map1.put("C", 30);

        // Your Stream code here


        // 6. Find the Second Lowest Number
        // Expected: 20
        List<Integer> nums4 = Arrays.asList(10, 20, 30, 40);

        // Your Stream code here


        // 7. Check If Any String Starts With "S"
        // Expected: true
        List<String> words2 = Arrays.asList("Java", "Stream", "API");

        // Your Stream code here


        // 8. Convert List to Set
        // Expected: [1, 2, 3, 4]
        List<Integer> nums5 = Arrays.asList(1, 2, 2, 3, 4, 4);

        // Your Stream code here


        // 9. Group Strings by First Character
        // Expected example:
        // {J=[Java], S=[Stream], A=[API]}
        List<String> words3 = Arrays.asList("Java", "Stream", "API");

        // Your Stream code here


        // 10. Find Total Characters Count in All Strings
        // Expected: 13
        List<String> words4 = Arrays.asList("Java", "API", "Stream");

        // Your Stream code here
    }
}
