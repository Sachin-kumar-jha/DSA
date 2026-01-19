import java.util.*;
import java.util.stream.*;

public class StreamPractice {

    public static void main(String[] args) {

        // 1. Filter Even Numbers
        // Expected: [2, 4, 6, 8]
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        
       List<Integer> evenNums = numbers1.stream().filter(x->x%2==0).toList();
       System.out.println(evenNums);


        // 2. Convert to Uppercase
        // Expected: ["JAVA", "STREAM", "API", "PRACTICE"]
        List<String> words1 = Arrays.asList("java", "stream", "api", "practice");

     List<String>newwords1= words1.stream().map(x->x.toUpperCase()).toList();
       System.out.println(newwords1);


        // 3. Count Elements Greater Than N
        // N = 10
        // Expected count: 3  (12, 15, 20)
        List<Integer> numbers2 = Arrays.asList(5, 10, 12, 3, 15, 7, 20);
        int N = 10;

      List<Integer>list2=  numbers2.stream().filter(x->x>N).toList();
      System.out.println(list2);
        // Your Stream code here


        // 4. Find First Element Starting With 'A'
        // Expected: "Apple"
        List<String> fruits = Arrays.asList("Banana", "Apple", "Avocado", "Mango");
     String result=  fruits.stream().filter(x->x.startsWith("A")).findFirst().orElse(null);
    System.out.println(result);
        // Your Stream code here


        // 5. Sum of Squares
        // Expected: 55  (1² + 2² + 3² + 5² = 55)
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 5);
System.out.println(numbers3.stream().map(x->x*x).reduce(0,(a,b)->a+b));

        // 6. Remove Duplicates
        // Expected: [1, 2, 3, 4, 5]
        List<Integer> numbers4 = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 1);
       List<Integer>res=   numbers4.stream().distinct().toList();
    System.out.println(res);

        // 7. Sort Strings by Length
        // Expected: ["API", "Java", "Stream", "Practice"]

        List<String> words2 = Arrays.asList("Stream", "Java", "Practice", "API");
      List<String>sorted= words2.stream().sorted((a,b)->a.length()-b.length()).toList();
 System.out.println(sorted);

        // 8. Group Strings by Length
        // Expected example:
        // {3=[API], 4=[Java], 6=[Stream], 8=[Practice]}
        List<String> words3 = Arrays.asList("Java", "Stream", "API", "Practice");
        Map<Integer,List<String>>ans= words3.stream().collect(Collectors.groupingBy(x->x.length()));
        System.out.println(ans);


        // 9. Find Second Highest Number
        // Expected: 40
        List<Integer> numbers5 = Arrays.asList(10, 20, 50, 40, 30);
          Integer secondMax=  numbers5.stream().distinct().sorted((a,b)->b-a).skip(1).findFirst().orElse(null);
          System.out.println(secondMax);
        // Your Stream code here


        // 10. Frequency Map
        // Expected:
        // {java=3, stream=2, api=1}
        List<String> words4 = Arrays.asList(
                "java", "stream", "java", "api", "stream", "java"
        );
       
      Map<String,Long>freqMap = words4.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
     System.out.println(freqMap);
    
    }

   
}
