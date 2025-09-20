package String;

public class MaxNestedParrenthesisDepth {
    public static int maxDepth(String s) {
      int currentDepth=0;
      int maxDepth=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
               currentDepth++;
               maxDepth=Math.max(maxDepth,currentDepth);
            }else if(s.charAt(i)==')'){
                currentDepth--;
            }
        }
       return maxDepth;
    }
public static void main(String[] args) {
    String s="(1+(2*3)+((8)/4))+1";
    System.out.println(maxDepth(s));
}
}
