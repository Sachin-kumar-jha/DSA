package String;



public class Permutaion {
public static  void  FindPermutaiton(String str,String ans){

    //Base case 
    if(str.length()==0){
        System.out.println(ans);
        return;
    }
    for(int i=0;i<str.length();i++){
        char curr = str.charAt(i);
        String newStr = str.substring(0, i)+str.substring(i+1);

        FindPermutaiton(newStr, ans+curr);
    }

}
    public static void main(String[] args) {
        String str="abc";
        FindPermutaiton(str,"");

        int nums[]={1,2,3,4,5,6,7,8,9,10};
       
      
     
    }
}
