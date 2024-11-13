package String;
import java.util.*;

public class Pallindrom {
    public static boolean isPallindrom(Stack<Character>ch,String str,String st){
        for(int i=0;i<str.length();i++){
            ch.push(str.charAt(i));
        }
        int size=ch.size();
        while (size>0){
            st+=ch.pop();
            size--;
        }
        if (str==st){
            System.out.println(st);
            System.out.println("same");;
        }else{
            System.out.println("diff");
        }
        
  return true;
           
    }

    public static void main(String[] args) {
        Stack<Character>ch=new Stack<>();
        String str="madam";
        String st="";
System.out.println(isPallindrom(ch, str,st));


    }
}