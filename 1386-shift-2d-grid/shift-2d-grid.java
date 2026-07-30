class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int row = grid.length;
        int col = grid[0].length;

        int n = row * col;
        k %= n;

        reverse (grid, 0, n-1, col);
        reverse (grid, 0, k-1, col);
        reverse (grid, k, n-1, col);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < row; i++) {
        List<Integer> list = new ArrayList<>();
        for(int j = 0; j < col; j++) {
        list.add(grid[i][j]);
    }
    ans.add(list);
    }
    return ans;
}
    private void reverse(int[] [] grid, int i, int j, int col) {
        while (i < j) {
        int temp = grid[i / col][i % col];
        grid[i / col][i % col] = grid[j / col][j % col];
        grid[j / col][j % col] = temp;
        i++;
        j--;
    }
    }
}