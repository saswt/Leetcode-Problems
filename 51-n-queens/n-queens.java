/* ==================== N-Queens Algorithm ====================
1. Place ONE queen in EACH column.
2. Try every row of the current column.
3. Before placing, check:
      - Row is free
      - Upper diagonal is free
      - Lower diagonal is free
4. If safe, place the queen ('Q').
5. Mark row and diagonals as occupied (1).
6. Move to the next column using recursion.
7. If all columns are filled, save the board as one answer.
8. After recursion, remove the queen (Backtracking).
9. Unmark row and diagonals (set back to 0).
10. Continue trying other rows until every possibility is explored.
*/
//Memory Trick:- TRY → PLACE → MARK → RECURSE → REMOVE → UNMARK → REPEAT

import java.util.*;
class Solution {
    public void solve(int col,
        List<String> board,
        List<List<String>> ans,
        int[] leftRow,
        int[] upperDiagonal,
        int[] lowerDiagonal,
        int n) {
            //Base case
            if(col == n) {
                ans.add(new ArrayList<>(board));
                return;
            }

            for(int row = 0; row < n; row++) {
                if(leftRow[row] == 0 &&
                lowerDiagonal[row + col] == 0 &&
                upperDiagonal[n - 1 + col - row] == 0) {
                    char[] chars = board.get(row).toCharArray();
                    chars[col] = 'Q';
                    board.set(row, new String(chars));


                    leftRow[row] = 1;
                    lowerDiagonal[row + col] = 1;
                    upperDiagonal[n - 1 + col - row] = 1;
                    
                    solve(col + 1, board, ans, leftRow, upperDiagonal, lowerDiagonal, n);
                    chars = board.get(row).toCharArray();
                    chars [col] = '.';
                    board.set(row, new String(chars));

                    leftRow[row] = 0;
                    lowerDiagonal[row + col] = 0;
                    upperDiagonal[n - 1 + col - row] = 0;
                }
            }
        }
    public List<List<String>> solveNQueens(int n) {
     List<List<String>> ans = new ArrayList<>();
     List<String> board = new ArrayList<>();
     String row = ".".repeat(n);

     for(int i = 0; i < n; i++){
        board.add(row);
     }
     int[] leftRow = new int [n];
     int[] upperDiagonal = new int [2 * n - 1];
     int[] lowerDiagonal = new int [2 * n - 1];
     solve(0, board, ans, leftRow, upperDiagonal, lowerDiagonal, n);
     return ans;
        
    }
}
/* Time Complexity: O(N!)
   N = N * (N - 1) * (N - 2) * (N -3) *.....* 1
   Space Complexity:O(N^2), includig board
*/