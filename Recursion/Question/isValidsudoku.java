package Recursion.Question;
class isValidSudoku {
    public boolean isvalidSudoku(char[][] board) {
        return validSudoku(board,0,0);
    }



    public boolean validSudoku(char[][]board ,int row,int col){
       if(row == 9){
        return true;
       }
       int nextRow=row ,nextCol = col+1;
       if(col+1==9){
              nextRow = row+1;
              nextCol=0;
       }

if(board[row][col] != '.'){
    return validSudoku(board,nextRow,nextCol);
}
       for(int i=0;i<=8;i++){
        for(int j=0;j<=8;j++){
            if(isSafe(board,row,col,board[i][j])){
                if(validSudoku(board,nextRow,nextCol)){
                    return true; 
                }
            }
        }
       }
       return true;
        }


public boolean isSafe(char[][] board,int row,int col,char digit){
    for(int i=0;i<=8;i++){
        if(board[i][col]==digit){
            return false;
        }
    }

    for(int j=0;j<=8;j++){
        if(board[row][j]==digit){
            return false;
        }
    }

    // Sub-boxes
    int stIdxOfRow=(row/3)*3;
    int stIdxOfCol=(col/3)*3;
//For running loop in this box length stIdxOfrow+3
    for(int i=0;i<=stIdxOfRow+3;i++){
        for(int j=0;j<=stIdxOfCol;j++){
            if(board[i][j]==digit){
                return false;
            }
        }
    }

  return true;
}



}