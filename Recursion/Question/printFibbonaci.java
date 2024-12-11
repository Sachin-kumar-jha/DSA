package Recursion;

public class printFibbonaci {
    public static int printFibbonaciNumber(int n){
        if (n==0 || n==1) {
            return n;
        }
        int fibonnaciNum = printFibbonaciNumber(n-1)+printFibbonaciNumber(n-2 );
        return fibonnaciNum;
    }

    public static void main(String[] args) {
        System.out.println(printFibbonaciNumber(8  ));
    }
}
