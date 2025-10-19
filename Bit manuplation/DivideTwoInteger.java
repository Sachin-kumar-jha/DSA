public class DivideTwoInteger {

    public int divide(int dividend, int divisor) {
        // if(dividend == divisor) return 1;
        // if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        // if(divisor == 1) return dividend;
        

        // boolean isPositive = true;
        
  
        // if(dividend >= 0 && divisor < 0) 
        //     isPositive = false;
        // else if(dividend < 0 && divisor > 0)
        //     isPositive = false;
            

        // long n = dividend;
        // long d = divisor;

        // n = Math.abs(n);
        // d = Math.abs(d);
        // long ans = 0, sum = 0;
        
     
        // while(sum + d <= n) {
        //     ans++;
        //     sum += d;
        // }
        
  
        // if(ans > Integer.MAX_VALUE && isPositive) 
        //     return Integer.MAX_VALUE;
        // if(ans > Integer.MAX_VALUE && !isPositive)
        //     return Integer.MIN_VALUE;
        
        
        // return isPositive ? (int)ans : (int)(-1 * ans);

        if (dividend == divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        
        
        boolean isPositive = true;
        
        if (dividend >= 0 && divisor < 0) 
            isPositive = false;
        else if (dividend < 0 && divisor > 0)
            isPositive = false;
            
       
        long n = dividend;
        long d = divisor;

        n = Math.abs(n);
        d = Math.abs(d);
        
        long ans = 0, sum = 0;
        
      
        while (sum + d <= n) {
            ans++;
            sum += d;
        }
        
    
        if (ans > Integer.MAX_VALUE && isPositive) 
            return Integer.MAX_VALUE;
        if (ans > Integer.MAX_VALUE && !isPositive)
            return Integer.MIN_VALUE;
        
        return isPositive ? (int)ans : (int)(-1 * ans);
    }

}