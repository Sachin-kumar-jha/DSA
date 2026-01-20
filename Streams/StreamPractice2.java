import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamPractice2 {

    public static void main(String[] args) {

        // 11. Find All Numbers Starting With Digit 1
        // Expected: [10, 12, 19]
        List<Integer> nums1 = Arrays.asList(1, 10, 12, 23, 19, 45, 7);
     List<Integer>res11 =  nums1.stream().filter(x->String.valueOf(x).startsWith("1")).toList();
System.out.println(res11);

        // 12. Find the Longest String
        // Expected: "Practice"
        List<String> words1 = Arrays.asList("Java", "API", "Stream", "Practice");
        
     String res =   words1.stream().reduce((a,b)->a.length()>=b.length()?a:b).orElse(null);
         System.out.println(res);

        // 13. Convert List of Strings to Comma-Separated String
        // Expected: "Java,Stream,API,Practice"
        List<String> words2 = Arrays.asList("Java", "Stream", "API", "Practice");
        System.out.println( words2.stream().collect(Collectors.joining(",")));  

        


        // 14. Partition Numbers into Even and Odd
        // Expected:
        // true  -> [2, 4, 6, 8]
        // false -> [1, 3, 5, 7]
        List<Integer> nums2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
     
     Map<Boolean,List<Integer>> paritoMap=   nums2.stream().collect(Collectors.partitioningBy(x->x%2==0));
       
System.out.println(paritoMap);

        // 15. Find Maximum Number
        // Expected: 50
        List<Integer> nums3 = Arrays.asList(10, 20, 50, 40, 30);

    Integer max =   nums3.stream().reduce((a,b)->a>b?a:b).orElse(null);
System.out.println(max);

        // 16. Remove Null Values
        // Expected: ["Java", "Stream", "API"]
        List<String> words3 = Arrays.asList("Java", null, "Stream", null, "API");

     List<String>list=   words3.stream().filter(x->x!=null).toList();
       System.out.println(list);

        // 17. Group Employees by Department
        // Expected example:
        // {IT=[Alice, Bob], HR=[John]}
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT"),
                new Employee("Bob", "IT"),
                new Employee("John", "HR")
        );

      Map<String,List<Employee>> map1=  employees.stream().collect(Collectors.groupingBy(e->e.department));
System.out.println(map1);

        // 18. Check If All Numbers Are Positive
        // Expected: true
        List<Integer> nums4 = Arrays.asList(1, 3, 5, 7, 9);
        boolean allPositive =   nums4.stream().allMatch(x->x>0);
        System.out.println(allPositive);


        // 19. Find First Non-Repeated Character in String
        // Input: "streams"
        // Expected: 't'
        String input = "streams";

      Character firstNonRepedted=  input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(x->x,LinkedHashMap::new,Collectors.counting())).entrySet()
        .stream()
        .filter(e->e.getValue()==1)
        .map(e->e.getKey())
        .findFirst()
        .orElse(null);
        System.out.println(firstNonRepedted);


        // 20. Flatten List of Lists
        // Expected: [1, 2, 3, 4, 5, 6]
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );
List<Integer>flat = nestedList.stream().flatMap(x->x.stream()).toList();
System.out.println(flat);
        // Your Stream code here
    }
}

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    @Override
    public String toString() {
        return name;
    }
}
