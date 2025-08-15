package String;
public class FindSubsets {
public static void findSubsets(String str, String current, int index) {
    //Base case: if index is equal to the length of the string, print the current subset
    if(index==str.length()){
        if(current.isEmpty()) {
            System.out.println("null");
        }else {
            System.out.println(current);
        }
        return;
    }
    //recursion
   
    //Yes choice
     findSubsets(str,current+str.charAt(index),index+1);
    //No choice
    findSubsets(str,current,index+1);

    
}
public static void main(String[] args) {
    String str = "abc";
    String ans ="";
    findSubsets(str,ans,0);
}
}