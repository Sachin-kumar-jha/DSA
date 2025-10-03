package Recursion.Question;

public class Power {
    public double myPow(double x, int n) {
        double ans=1.0;
         long val=n;

        if(val<0) val= -1*val;

        while(val>0){
            if(val%2!=0){
                ans=ans*x;
                val=val-1;
            }else{
                x=x*x;
                val=val/2;
            }
        }
if(n<0) ans = (double)1.0/(double)ans;
return ans; 
    }

}
