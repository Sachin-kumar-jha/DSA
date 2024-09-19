package Question;
import java.util.*;
public class ReverseStr {
    
public static void reverseStr(Stack<Character>s,String str){
    int idx=0;
    while (idx<str.length()) {
        s.push(str.charAt(idx));
        idx++;
    }

    StringBuilder result=new StringBuilder("");
    while (!s.isEmpty()) {
        char curr=s.pop();
        result.append(curr);
       
}
    
    System.out.println(result.toString());
}



    public static void main(String[] args) {
       Stack<Character>s=new Stack<>();
String temp="Worldhello";
reverseStr(s,temp);
       
    }
}
