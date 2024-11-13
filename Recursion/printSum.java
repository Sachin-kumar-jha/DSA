package Recursion;

public class printSum{
    public static int PrintSumofNnaturalNumber(int n){
           if (n==0) {
            return 0;
           }
        int sum= n+PrintSumofNnaturalNumber(n-1);
        return sum;
    }
    public static void main(String[] args) {
        System.out.println( PrintSumofNnaturalNumber(10));
       
    }
    
}
