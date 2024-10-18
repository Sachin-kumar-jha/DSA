package Recursion;
public class printDec{
    public static void Print(int n){
        if (n==1) {
         System.out.print(n +" ");
         return;
        }
        System.out.print(n + " ");
        Print(n-1);
        
    }
    public static void main(String[] args) {
        Print(10);
    }
}

