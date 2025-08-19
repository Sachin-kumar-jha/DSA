package Recursion.Question;
class Solution {
    public static boolean isValidSudoku(char[][] board) {
        return validSudoku(board,0,0);
    }



    public static boolean validSudoku(char[][]board ,int row,int col){
       if(row == 9){
        return true;
       }
       int nextRow = row , nextCol = col+1;
       if(col+1 == 9){
              nextRow = row+1;
              nextCol=0;
       }
if(board[row][col] !='.'){
   if(!isSafe(board,row,col,board[row][col])){
    return false;
     }
}

 return validSudoku(board, nextRow, nextCol);
        }


public static boolean isSafe(char[][] board,int row,int col,char digit){
    for(int i=0;i<=8;i++){
        if(i!=row && board[i][col] == digit){
            return false;
        }
    }

    for(int j=0;j<=8;j++){
        if( j!=col && board[row][j]==digit){
            return false;
        }
    }

    // Sub-boxes
    int sr=(row/3)*3;
    int sc=(col/3)*3;
//For running loop in this box length stIdxOfrow+3
    for(int i=sr;i<sr+3;i++){
        for(int j=sc;j<sc+3;j++){
            if((i != row || j != col) && board[i][j]==digit){
                return false;
            }
        }
    }

  return true;
}

public static void main(String[] args) {
char[][] board = {
    {'5','3','4','6','7','8','9','1','2'},
    {'6','7','2','1','9','5','3','4','8'},
    {'1','9','8','3','4','2','5','6','7'},
    {'8','5','9','7','6','1','4','2','3'},
    {'4','2','6','8','5','3','7','9','1'},
    {'7','1','3','9','2','4','8','5','6'},
    {'9','6','1','5','3','7','2','8','4'},
    {'2','8','7','4','1','9','6','3','5'},
    {'3','4','5','2','8','6','1','7','9'}
};


System.out.println(isValidSudoku(board));
}
}