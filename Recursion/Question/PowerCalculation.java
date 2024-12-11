package Recursion.Question;
public class PowerCalculation{

// public static int power(int x,int n){
//     if (n==0) {
//         return 1;
//     }
//     int xnm1 = power(x, n-1);
//     int xn= x*xnm1;
//     return xn;
// }

public static long optimizePower(int a ,int n){
if (n == 0) {
    return 1;
}
    long halfPower= optimizePower(a,n/2);
    long halfPowerSq= halfPower * halfPower;

if (n % 2 != 0) {
    halfPowerSq= a * halfPowerSq;
}
return halfPowerSq;
}
    public static void main(String[] args) {
        int a=2;
        int n=35;
        System.out.println(optimizePower(a, n));
    }





}