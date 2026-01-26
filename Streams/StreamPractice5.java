import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPractice5 {

    public static void main(String[] args) {

        // 1. Find the Smallest Missing Positive Number
        // Input: [3, 4, -1, 1]
        // Expected: 2
        List<Integer> nums1 = Arrays.asList(3, 4, -1, 1);
        List<Integer> pos=nums1.stream().filter(x->x>0).distinct().sorted().toList();
        int missing=1;
        for(int n:pos){
            if(n==missing) missing++;
            else if(missing<n) break;
        }
         System.out.println(missing);
        // 2. Find All Numbers That Appear Exactly Twice
        // Input: [1, 2, 2, 3, 3, 3, 4]
        // Expected: [2]
        List<Integer> nums2 = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
    Map<Integer,Long>mapperMap= nums2.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
    System.out.println(mapperMap);
    List<Integer>l = mapperMap.entrySet().stream().filter(x->x.getValue()==2).map(e->e.getKey()).toList();
    System.out.println(l);
        // Your Stream code here


        // 3. Find First Repeated Character in a String
        // Input: "interview"
        // Expected: 'i'
        String input1 = "interview";
         Set<Character>set = new HashSet<>();
          
        Character fisrstRepeat =  input1.chars().mapToObj(c->Character.valueOf((char)c))
        .filter(c->{
            boolean seen = set.add(c);
            return !seen;
        }).findFirst().orElse(null);
        System.out.println(fisrstRepeat);
        // Your Stream code here


        // 4. Sort Strings by Length, Then Alphabetically
        // Input: ["bat", "apple", "ball", "ant"]
        // Expected: ["ant", "bat", "ball", "apple"]
        List<String> words1 = Arrays.asList("bat", "apple", "ball", "ant");
       List<String>newwords=   words1.stream().sorted((a,b)->a.length()-b.length()).sorted((a,b)->a.compareTo(b)).toList();
       List<String>newwords2 = words1.stream().sorted((a,b)->{
        int diff =  a.length()-b.length();
        if(diff!=0) return diff;
        else  return a.compareTo(b);
    }).toList();
       System.out.println(newwords2);
       
        // 5. Count Words Starting With a Vowel
        // Input: "Apple is an orange"

        // Expected: 3
        String sentence = "Apple is an orange";
        String [] sen=sentence.split(" ");
long vowelStartCount = Arrays.stream(sen)
    .filter(s -> s != null && !s.isEmpty())
    .filter(s -> {
        char firstChar = Character.toLowerCase(s.charAt(0));
        return "aeiou".indexOf(firstChar) != -1;
    })
    .count();
System.out.println(vowelStartCount);
   long count =  Arrays.stream(sen).filter(s-> !s.isEmpty() && s!=null)
        .filter(x->x.toLowerCase().matches("^[aeiou].*")).count();
System.out.println(count);
       
        // Your Stream code here


        // 6. Find the Product of All Numbers Except Zero
        // Input: [1, 2, 0, 4]
        // Expected: 8
        List<Integer> nums3 = Arrays.asList(1, 2, 0, 4);
       
       Integer prodInteger=  nums3.stream().filter(n->n!=0).reduce(1,(a,b)->a*b);
 System.out.println(prodInteger);
        // Your Stream code here


        // 7. Convert List<String> to Map<String, Integer> (Word → Frequency)
        // Input: ["java", "stream", "java", "api"]
        // Expected: {java=2, stream=1, api=1}
        List<String> words2 = Arrays.asList("java", "stream", "java", "api");

           Map<String,Long>ans =  words2.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
           System.out.println(ans);

        // 8. Find the Longest Palindrome Word
        // Input: ["level", "java", "radar", "stream"]
        // Expected: "radar",level
        List<String> words3 = Arrays.asList("level", "java", "radar", "stream");
      
       String s=  words3.stream().filter(x->isPallindrom(x)).max((a,b)->Integer.compare(a.length(), b.length())).orElse("String is not pallidrom");

         System.out.println(s);


        // 9. Flatten Map<K, List<V>> to List<V>
        // Input: {A=[1,2], B=[3], C=[4,5]}
        // Expected: [1, 2, 3, 4, 5]
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("A", Arrays.asList(1, 2));
        map.put("B", Arrays.asList(3));
        map.put("C", Arrays.asList(4, 5));

       List<Integer> list = map.entrySet().stream().flatMap(x -> x.getValue().stream()).collect(Collectors.toList());
 System.out.println(list);


        // 10. Check If a List Is Sorted in Ascending Order
        // Input: [1, 2, 3, 4, 5]
        // Expected: true
        List<Integer> nums4 = Arrays.asList(1, 2, 3, 4, 5);
       boolean bool =   IntStream.range(0, nums4.size()-1).allMatch(i->nums4.get(i)<=nums4.get(i+1));
        System.out.println(bool);
    }
    private static boolean isPallindrom(String s){
        int i=0;
        int j = s.length()-1;
        while (i!=j) {
             if(s.charAt(i)!=s.charAt(j)){
                return false;
             }
             i++;
             j--;
        }
        return true;
    }
}