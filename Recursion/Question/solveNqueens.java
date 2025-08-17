package Recursion.Question;

import java.util.ArrayList;
import java.util.List;

public class solveNqueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtracking(n, board, result, 0);
        return result;
    }

    public void backtracking(int n,char board[][], List<List<String>> result, int row) {
        

        if (row == n) {
        List<String> temp=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            result.add(temp);
            return;
        }

        for (int i = 0; i <n; i++) {
            if (isSafe(board,n, row, i)) {
                board[row][i] = 'Q';
                backtracking(n, board, result, row + 1);
                board[row][i] = '.';
            }
        }

    }

    public boolean isSafe(char[][] board,int n, int row, int col) {
        // For vetical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // For left diagonal

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // for right diagonal row-- ,col++
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

}
