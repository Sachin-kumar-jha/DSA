package String;
import java.util.*;

public class Pallindrom {

    // public static isMatch(String str,String st){
        
    // }


    public static boolean isPallindrom(Stack<Character>ch,String str,String st){
        int i=0;
        while (i < str.length()) {
            // if (str.charAt(i) == ',' || str.charAt(i) == ':' || str.charAt(i) == '?' || str.charAt(i) == '&' || str.charAt(i) == '*' || str.charAt(i)==' ') {
            //     i++;
            // }
            ch.push(str.charAt(i));
            i++;
        }
        int size=ch.size();
        while (size>0){
            st+=ch.pop();
            size--;
        }
        int j=0;
        while (j<str.length() && j<st.length()){
            if (str.charAt(j) != str.charAt(j)){
                return false;
            }
            j++;
        }

        System.out.println("hello");
  return true;
           
    }

    public static void main(String[] args) {
        Stack<Character>ch=new Stack<>();
        String str="abc";
        System.out.println(str.length());
        String st="";
System.out.println(isPallindrom(ch, str,st));


    }
}