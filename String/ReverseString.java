
package String;
import java.util.*;
import java.util.List;

class ReverseString {
    public static String reverseWords(String s) {
      String str[] = s.split(" ");
      String str1="";
List<String> list=new ArrayList<>();
      for(String st:str){
     list.add(st);
      }

      Collections.reverse(list);
      
      for(String str2:list){
        str1+=str2+" ";

      }
     return str1;
    }

    public static void main(String[] args) {
        String str="This is house";
        System.out.println(reverseWords(str));
    }
}