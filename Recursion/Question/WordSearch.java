public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int index, String word) {

        if (index == word.length()) return true;
        // Check bounds and character match
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all 4 directions

        boolean found = dfs(board, i + 1, j, index + 1, word) ||
                        dfs(board, i - 1, j, index + 1, word) ||
                        dfs(board, i, j + 1, index + 1, word) ||
                        dfs(board, i, j - 1, index + 1, word);

        // Restore cell
        
        board[i][j] = temp;

        return found;
    }

}
