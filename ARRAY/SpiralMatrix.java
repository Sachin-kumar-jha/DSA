package ARRAY;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left=0; 
        int right=m-1;
        int top=0;
        int bottom=n-1;
        List<Integer> list =new ArrayList<>();

        while (left<=right && top<=bottom) {
            /* Moving left to right */
        for(int i=left;i<=right;i++){
         list.add(matrix[top][i]);
        }
        top++;

        /** Moving top to botton  */
        for(int i=top;i<=bottom;i++){
            list.add(matrix[i][right]);
        }
        right--;

        /** Moving right to left   */
        if (top<=bottom) {
        for(int i=right;i>=left;i--){
            list.add(matrix[bottom][i]);
        }
        bottom--;    
        }
        
        /** Moving bottom to top   */
        if (left<=right) {
            for(int i=bottom;i>=top;i--){
           list.add(matrix[i][left]);
        }
        left++;
        }
        }
        
return list;
    }

    public static void main(String[] args) {
         int matrix[][]={{1,2,3},{4,5,6},{7,8,9}};

      for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
              System.out.print(matrix[i][j]+" ");

            }
            System.out.println();
        }
  List<Integer>ls=spiralOrder(matrix);
  System.out.println(ls);

    }
}
