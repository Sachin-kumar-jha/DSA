
package Recursion.Question;
public class Grid {

    public static void main(String[] args) {
        int  row =7;
        int col=4;
        

    // int ways = calculateWays(0,0,row,col);
    int ways= calculateByformula(row ,col);
    System.out.println(ways);
    
    }
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

    private static int calculateByformula(int row, int col) {
        
        int factorial= FactorialOfN(row-1+col-1)/(FactorialOfN(row-1)*FactorialOfN(col-1));
        return  factorial;
    }


    private static int calculateWays(int i,int j,int row, int col) {
        
        if (i>=row-1 || j>=col-1) {
            return 1;
         } // }else if (i==row || j==col) {
        //     return 0;
        // }

        int way1 = calculateWays(i, j+1, row, col);
        int way2 = calculateWays(i+1, j, row, col);
        return way1 + way2;
    }
    
}