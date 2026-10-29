//Time Complexity: O(9 ^ 81)
//Since it's a constant value, it will not impact anything much. But, it's also a very large value in theoretical terms.
class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++) {//O(9)
            for(int j = 0; j < 9; j++) {//O(9)
                if(board[i][j] == '.') {
                    for(char d = '1'; d <= '9'; d++) {
                        if(isValid(board, i, j, d)) {
                            board[i][j] = d;

                            if(solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char d) {
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == d) return false;//check column
            if(board[row][i] == d) return false;//check row
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for(int k = 0; k < 3; k++) {
            for(int l = 0; l < 3; l++) {
                if(board[startRow + k][startCol + l] == d) {
                    return false;
                }
            }
        }
        return true;
    }
}