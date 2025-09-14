package String;

import java.util.Arrays;

public class Anagram {
     public static boolean isAnagram(String s, String t) {
    //    String newStr1=sortString(t);
    //    String newStr2=sortString(s);
       
    //    if(newStr1.equals(newStr2)){
    //     return true;
    //    }
    //    return false;
    // }

    // public String sortString(String t){
    //     char c[]=t.toCharArray();
    //      Arrays.sort(c);
    //      return new String(c);
       
    // }

     if(s.length()!=t.length()){
            return false;
        }
        else{
            char[] s1=s.toCharArray();
            char[] s2=t.toCharArray();
           
            Arrays.sort(s1);
            Arrays.sort(s2);

            if(Arrays.equals(s1,s2)){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
