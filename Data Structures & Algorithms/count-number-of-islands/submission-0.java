class Solution {
    public int numIslands(char[][] grid) {
        int row_len = grid.length;
        int col_len = grid[0].length;
        int islands = 0;
        int[][] explored = new int[grid.length][grid[0].length];
        for(int i = 0; i < row_len; i++) {
            for(int j = 0; j < col_len; j++) {
                if(explored[i][j] == 0) {
                    if(grid[i][j] == '1')  {
                        islands++;
                        explore(i, j, explored, grid);
                    }
                    else {
                        explored[i][j] = 1;
                    }
                }
            }
        }
        return islands;
    }

    private void explore(int row, int col, int[][] explored, char[][] grid) {
        if(row < 0 || row > explored.length - 1 
        || col < 0 || col > explored[0].length - 1
        || explored[row][col] == 1) {
            return;
        }
        explored[row][col] = 1;
        if(grid[row][col] == '1') {
            explore(row + 1, col, explored, grid);
            explore(row - 1, col, explored, grid);
            explore(row, col + 1, explored, grid);
            explore(row, col - 1, explored, grid);
        }
    }
}
