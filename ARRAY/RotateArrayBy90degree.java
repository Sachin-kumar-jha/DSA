package ARRAY;
class RotateArrayBy90degree {
    public static int[][] rotate(int[][] matrix) {
        /**
        brute force approach
        
        int ans [][]=new int[matrix.length][matrix.length]
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                ans[i][matrix.length-1-i]=matrix[i][j];

            }
        } */
        int ans [][]=new int[matrix.length][matrix[0].length];
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                ans[j][matrix.length-1-i]= matrix[i][j];

            }
        }
return ans;
    }

public static void optimalRotate(int matrix[][]){
    
    int n= matrix.length;
    for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            swap(matrix,i,j);
        }
    }
}

       public static void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

public static void reverseRows(int[][] matrix) {
        int n = matrix.length;       // number of rows
        int m = matrix[0].length;    // number of columns

        for (int i = 0; i < n; i++) {
            int left = 0, right = m - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][]={{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

      for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
              System.out.print(matrix[i][j]+" ");

            }
            System.out.println();
        }
System.out.println();

optimalRotate(matrix);
reverseRows(matrix);
for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
              System.out.print(matrix[i][j]+" ");

            }
            System.out.println();
        }

    //     int ans[][]=rotate(matrix);

    //     for(int i=0;i<ans.length;i++){
    //         for(int j=0;j<ans.length;j++){
    //           System.out.print(ans[i][j]+" ");

    //         }
    //         System.out.println();
    //     }
     }


    
}