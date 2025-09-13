package ARRAY;

public class FindPeakGrid {
    public static int[] findpeakGrid(int[][] mat) {
        int low =0;
       // int high=mat.length-1; 
        int high=mat[0].length-1;

        while(low<=high){
            int mid = (low+high)/2;
            // int col = maxel(mat[mid]);
            int row = maxel(mat,mid);
         int left = mid-1 >= 0 ? mat[row][mid-1]:-1;
        //  int right= mid+1 < mat.length-1 ? mat[mid+1][col]:-1;
        int right= mid+1 < mat[0].length ? mat[row][mid+1]:-1;
        //  if(mat[mid][col] > left && mat[mid][col] > right){
        //     return new int[]{mid,col};
        //  }else if(mat[mid][col]<left){
        //     high=mid-1;
        //  }else{
        //     low =mid+1;
        //  }

         if(mat[row][mid] > left && mat[row][mid] > right){
            return new int[]{row,mid};
         }else if(mat[row][mid]<left){
            high=mid-1;
         }else{
            low =mid+1;
         }
        }
        return new int[]{-1,-1};
    }


//Binary search happens on Rows.
//    public int maxel(int [] arr){ 
//    int maxVal=arr[0],idx=0;
//    for(int i=1;i<arr.length;i++){
//     if(arr[i]>maxVal){
//         maxVal=arr[i];
//         idx=i;
//     }
//    }
//    return idx;
// }


//Binary search happens on columns.
 public static int maxel(int [][] arr,int col){ 
   int maxVal=arr[0][col],idx=0;
   for(int i=1;i<arr.length;i++){
    if(arr[i][col]>maxVal){
        maxVal=arr[i][col];
        idx=i;
    }
   }
   return idx;
}


public static void main(String[] args) {
   int[][] mat = {{1, 4}, {3, 2}};
   

   for(int i:findpeakGrid(mat))System.out.print(i+" ");
 
}
}
    
