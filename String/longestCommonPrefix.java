package String;

import java.util.Arrays;

public class longestCommonPrefix {

    public static String longestCommonprefix(String[] strs) {
        StringBuilder str = new StringBuilder();
        
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 =strs[strs.length-1];

        for(int i=0;i<Math.min(s1.length(),s2.length());i++){
            if(s1.charAt(i)!=s2.charAt(i)) return str.toString();
            else str.append(s1.charAt(i));
        }
      
      return str.toString();
    }

    public static void main(String[] args) {
        String strs[]={"flower","flow","flight"};
        System.out.println(longestCommonprefix(strs));
    }
}
