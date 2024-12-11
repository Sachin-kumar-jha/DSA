package Recursion;

public class factorial {
    public static int FactorialOfN(int n){
        if (n==0) {
            return 1;
        }else if(n<0){
       System.out.println("Factorial of this number not Exist");
       return 0;
        }
        int factorial=n*FactorialOfN(n-1);
        return factorial; 
    }

    public static void main(String[] args) {
        System.out.print(FactorialOfN(5));
    }
}