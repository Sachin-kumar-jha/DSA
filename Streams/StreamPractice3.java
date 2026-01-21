import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamPractice3 {

    public static void main(String[] args) {

        // 1. Find Top 3 Highest Numbers
        // Expected: [90, 80, 70]
        List<Integer> nums1 = Arrays.asList(40, 90, 10, 80, 70, 60);
        Collections.reverse(nums1);
        
       System.out.println( nums1.stream().reduce((a,b)->a>b?a:b));
       List<Integer>newList= nums1.stream().sorted((a,b)->b-a)
        .limit(3)
        .toList();
        System.out.println(newList);

        // 2. Find Average of Numbers Greater Than 50
        // Expected: 80.0
        List<Integer> nums2 = Arrays.asList(40, 60, 80, 100, 20);
       double avg= nums2.stream().filter(x->x>50).mapToInt(x->x).average().orElse(0);
       System.out.println(avg);
      System.out.println( nums2.stream().filter(x->x>50).collect(Collectors.averagingDouble(x->x))); 
       


        // 3. Convert List of Strings to Map (String -> Length)
        // Expected: {Java=4, Stream=6, API=3}
        List<String> words1 = Arrays.asList("Java", "Stream", "API");
      Map<String,Integer>map= words1.stream().collect(Collectors.toMap(x->x,x->x.length()));
      System.out.println(map);
        


        // 4. Find Duplicate Elements
        // Expected: [2, 3]
        List<Integer> nums3 = Arrays.asList(1, 2, 2, 3, 3, 4, 5);
        Set<Integer> seen = new HashSet<>();

   List<Integer>duplicates=nums3.stream().filter(
            x->!seen.add(x)).distinct().toList();
System.out.println(duplicates);

        // 5. Sort Map by Values (Ascending)
        // Expected order: {B=10, A=20, C=30}
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 20);
        map1.put("B", 10);
        map1.put("C", 30);

/*
 Step-by-step explanation of the code below:

 1. map1.entrySet()
    - Converts the Map into a Set of Map.Entry objects (key–value pairs)
    - Maps cannot be sorted directly, so this conversion is required

 2. .stream()
    - Creates a Stream from the entry set so Stream operations can be applied

 3. .sorted((e1, e2) -> e1.getValue() - e2.getValue())
    - Sorts the stream of entries based on their values
    - e1.getValue() - e2.getValue() ensures ascending order
    - After sorting, the order becomes: B=10, A=20, C=30

 4. .collect(Collectors.toMap(...))
    - Collects the sorted stream back into a Map

    4.1 e -> e.getKey()
        - Specifies how to extract the key from each Map.Entry

    4.2 e -> e.getValue()
        - Specifies how to extract the value from each Map.Entry

    4.3 (a, b) -> a
        - Merge function to handle duplicate keys
        - Keeps the existing value if a duplicate key is encountered
        - Required to avoid IllegalStateException

    4.4 () -> new LinkedHashMap<>()
        - Specifies the Map implementation to use
        - LinkedHashMap preserves insertion order
        - Ensures the sorted order is maintained in the final Map

 5. Result
    - The final Map is sorted by value in ascending order
    - Output: {B=10, A=20, C=30}
*/

Map<String, Integer> sortedMap = map1.entrySet()
        .stream()
        .sorted((e1, e2) -> e1.getValue() - e2.getValue())
        .collect(Collectors.toMap(
                e -> e.getKey(),
                e -> e.getValue(),
                (a, b) -> a,
                LinkedHashMap::new
        ));

System.out.println(sortedMap);

     
        
        


        // 6. Find the Second Lowest Number
        // Expected: 20
        List<Integer> nums4 = Arrays.asList(10, 20, 30, 40);
      Integer secondLowest=  nums4.stream().distinct().sorted().skip(1).findFirst().orElse(null);
      System.out.println(secondLowest);
       




        // 7. Check If Any String Starts With "S"
        // Expected: true
        List<String> words2 = Arrays.asList("Java", "Stream", "API");
         words2.stream().anyMatch(x->x.startsWith("S"));


        // 8. Convert List to Set
        // Expected: [1, 2, 3, 4]
        List<Integer> nums5 = Arrays.asList(1, 2, 2, 3, 4, 4);
         Set<Integer>uniqset=  nums5.stream().collect(Collectors.toSet());
System.out.println(uniqset);

        // 9. Group Strings by First Character
        // Expected example:
        // {J=[Java], S=[Stream], A=[API]}
        List<String> words3 = Arrays.asList("Java", "Stream", "API");
        Map<Character,List<String>>firsMap= words3.stream().collect(Collectors.groupingBy(x->x.charAt(0)));
System.out.println(firsMap);


        // 10. Find Total Characters Count in All Strings
        // Expected: 13
        List<String> words4 = Arrays.asList("Java", "API", "Stream");
      System.out.println(words4.stream().mapToInt(x->x.length())
          .sum());      
    }
}
