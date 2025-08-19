package Recursion.Question;
public class Sudoku {

    public static boolean sudokuSolver(String sudoku[][],int row ,int col){

if(row == 9){
            return true;
        }
int nextRow = row ,nextCol= col+1;
if(col+1 ==9){
    nextRow=row+1;
     nextCol=0;
}
if(!sudoku[row][col].equals(".")){
    return sudokuSolver(sudoku, nextRow, nextCol);
}
        for(int digit=1;digit<=9;digit++){
         
            if(isSafe(sudoku,row,col,Integer.toString(digit))){
                sudoku[row][col]=Integer.toString(digit);
                if(sudokuSolver(sudoku,nextRow,nextCol)){
                    return true; 
                }
                sudoku[row][col] = ".";
            }
        }
        return false;
    }


    public static boolean isSafe(String sudoku[][],int row ,int col ,String digit){
        for(int i =0;i<=8;i++){
            if(sudoku[i][col].equals(digit)){
                return false;
            }
        }

        for(int j=0;j<=8;j++){
            if(sudoku[row][j].equals(digit)){
                return false;
            }
        }

        //grid 
        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for(int i =sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j].equals(digit)){
                     return false;
                }
            }
        }
        return true;
    }

    /** 
     * start of subgrid 
     * sr =(row/3)*3
     * sc=(col/3)*3
     * 
    */
     private static void printSudoku(String[][] sudoku) {
       for(int i =0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(
            sudoku[i][j]+" "
                );
            }
            System.out.println();
        }
    }

   
    public static void main(String[] args) {
       String sudoku[][]={
       {"5","3",".",".","7",".",".",".","."},
       {"6",".",".","1","9","5",".",".","."},
       {".","9","8",".",".",".",".","6","."},
       {"8",".",".",".","6",".",".",".","3"},
       {"4",".",".","8",".","3",".",".","1"},
       {"7",".",".",".","2",".",".",".","6"},
       {".","6",".",".",".",".","2","8","."},
       {".",".",".","4","1","9",".",".","5"},
       {".",".",".",".","8",".",".","7","9"}};

      
       if(sudokuSolver(sudoku, 0, 0)){
        System.out.println("solution exists");
        printSudoku(sudoku);
       }else{
        System.out.println("not exist");
       }
    }


   
}
