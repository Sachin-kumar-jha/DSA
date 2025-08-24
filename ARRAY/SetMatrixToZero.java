package ARRAY;

public class SetMatrixToZero {
    public static void setZeroes(int[][] matrix) {
        //Optimal solution here we have don't needed space complexity for extra column and row tracking 
        
         int col0=1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0; // row tracking
                     if(j!=0){
                        matrix[0][j]=0;
                     }else{
                        col0=0;
                     }
                }
            }
        }

          for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){

                if(matrix[i][j]!=0){
                    //Check if col or row is marked
                    if(matrix[0][j]==0 || matrix[i][0]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }

if(matrix[0][0]==0){
    for(int j=0;j<matrix[0].length;j++) matrix[0][j]=0;
}

if(col0==0){
      for(int i=0;i<matrix.length;i++) matrix[i][0]=0;
}
    }

    public static void main(String[] args) {
        int [][]arr={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(arr);
       for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[0].length;j++){
            System.out.print(arr[i][j] +" ");
        }
        System.out.println();
       }
    }
}
