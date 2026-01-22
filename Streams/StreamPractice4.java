import java.util.*;
import java.util.stream.Collectors;


public class StreamPractice4 {

    public static void main(String[] args) {

        // 1. Find the Kth Smallest Element
        // Input: [7, 10, 4, 3, 20, 15], k = 3
        // Expected: 7
        List<Integer> nums1 = Arrays.asList(7, 10, 4, 3, 20, 15);
        int k = 3;
       
      Integer val=  nums1.stream().sorted((a,b)->b-a).skip(k).findFirst().orElse(null);
       System.out.println(val);


        // 2. Find the Most Frequent Element
        // Input: [1, 3, 2, 1, 4, 1, 3]
        // Expected: 1
        List<Integer> nums2 = Arrays.asList(1, 3, 2, 1, 4, 1, 3);
        Map<Integer,Long> freMap = nums2.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
       Integer mostFrequent =   freMap.entrySet().stream().max((e1,e2)->Long.compare(e1.getValue(),e2.getValue()))
         .map(e->e.getKey()).orElse(null);
         System.out.println(mostFrequent);

  
    



        // 3. Find All Anagrams of a Given Word
        // Input: ["cat", "tac", "dog", "act", "god"], target = "cat"
        // Expected: ["cat", "tac", "act"]
        List<String> words1 = Arrays.asList("cat", "tac", "dog", "act", "god");
        String target = "cat";

    List<String>anagrams=   words1.stream().filter(word->{
        char[] w = word.toCharArray();
        char[] b = target.toCharArray();
        Arrays.sort(w);
        Arrays.sort(b);
        return Arrays.equals(w,b);
    }).toList();
    System.out.println(anagrams);
       
       


        // 4. Remove Duplicate Characters from a String (Preserve Order)
        // Input: "programming"
        // Expected: "progamin"
        String input1 = "programming";
        input1.chars().mapToObj(c->(char)c)
        .distinct()
        .map(String::valueOf)
        .collect(Collectors.joining());

        // Your Stream code here


        // 5. Find Longest Word in a Sentence
        // Input: "Java streams are powerful"
        // Expected: "powerful"
        String sentence = "Java streams are powerful";
       
        String[]arr = sentence.split(" ");
    String l =     Arrays.stream(arr).sorted((a,b)->b.length()-a.length()).findFirst().orElse(null);
    System.out.println(l);
         


        // 6. Partition Numbers into Prime and Non-Prime
        // Input: [2, 3, 4, 5, 6, 7, 8]
        // Expected:
        // true  -> [2, 3, 5, 7]
        // false -> [4, 6, 8]
        List<Integer> nums3 = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
      
     Map<Boolean,List<Integer>>newNums=nums3.stream().collect(Collectors.partitioningBy(x->isPrime(x)));
     System.out.println(newNums);
        // Your Stream code here


        // 7. Find Common Elements Between Two Lists
        // Input: [1, 2, 3, 4] and [3, 4, 5, 6]
        // Expected: [3, 4]
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
        
        // Your Stream code here


        // 8. Find the Word with Maximum Repeated Characters
        // Input: ["apple", "banana", "mississippi"]
        // Expected: "mississippi"
        List<String> words2 = Arrays.asList("apple", "banana", "mississippi");

        // Your Stream code here


        // 9. Convert Map<K, List<V>> to Map<K, V> (Sum of Values)
        // Input: {A=[10,20], B=[5,5], C=[7]}
        // Expected: {A=30, B=10, C=7}
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("A", Arrays.asList(10, 20));
        map.put("B", Arrays.asList(5, 5));
        map.put("C", Arrays.asList(7));

        // Your Stream code here


        // 10. Check If Two Strings Are Rotations of Each Other
        // Input: "abcd", "cdab"
        // Expected: true
        String s1 = "abcd";
        String s2 = "cdab";

        // Your Stream code here
    }
      private static boolean isPrime(int n){
            if(n<=1) return false;
            for(int i = 2;i<=Math.sqrt(n);i++){
                if(n%i==0) return false;
            }
            return true;
        };
}
