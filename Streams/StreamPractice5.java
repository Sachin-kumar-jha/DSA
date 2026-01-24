import java.util.*;

public class StreamPractice5 {

    public static void main(String[] args) {

        // 1. Find the Smallest Missing Positive Number
        // Input: [3, 4, -1, 1]
        // Expected: 2
        List<Integer> nums1 = Arrays.asList(3, 4, -1, 1);
        nums1.stream().sorted().


        // 2. Find All Numbers That Appear Exactly Twice
        // Input: [1, 2, 2, 3, 3, 3, 4]
        // Expected: [2]
        List<Integer> nums2 = Arrays.asList(1, 2, 2, 3, 3, 3, 4);

        // Your Stream code here


        // 3. Find First Repeated Character in a String
        // Input: "interview"
        // Expected: 'i'
        String input1 = "interview";

        // Your Stream code here


        // 4. Sort Strings by Length, Then Alphabetically
        // Input: ["bat", "apple", "ball", "ant"]
        // Expected: ["ant", "bat", "ball", "apple"]
        List<String> words1 = Arrays.asList("bat", "apple", "ball", "ant");

        // Your Stream code here


        // 5. Count Words Starting With a Vowel
        // Input: "Apple is an orange"
        // Expected: 3
        String sentence = "Apple is an orange";

        // Your Stream code here


        // 6. Find the Product of All Numbers Except Zero
        // Input: [1, 2, 0, 4]
        // Expected: 8
        List<Integer> nums3 = Arrays.asList(1, 2, 0, 4);

        // Your Stream code here


        // 7. Convert List<String> to Map<String, Integer> (Word → Frequency)
        // Input: ["java", "stream", "java", "api"]
        // Expected: {java=2, stream=1, api=1}
        List<String> words2 = Arrays.asList("java", "stream", "java", "api");

        // Your Stream code here


        // 8. Find the Longest Palindrome Word
        // Input: ["level", "java", "radar", "stream"]
        // Expected: "radar"
        List<String> words3 = Arrays.asList("level", "java", "radar", "stream");

        // Your Stream code here


        // 9. Flatten Map<K, List<V>> to List<V>
        // Input: {A=[1,2], B=[3], C=[4,5]}
        // Expected: [1, 2, 3, 4, 5]
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("A", Arrays.asList(1, 2));
        map.put("B", Arrays.asList(3));
        map.put("C", Arrays.asList(4, 5));

        // Your Stream code here


        // 10. Check If a List Is Sorted in Ascending Order
        // Input: [1, 2, 3, 4, 5]
        // Expected: true
        List<Integer> nums4 = Arrays.asList(1, 2, 3, 4, 5);

        // Your Stream code here
    }
}