class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] explored = new boolean[grid.length][grid[0].length];
        // have we explored this grid yet?
        // is this an island?
        int max_area = 0;
        for(int i = 0; i < explored.length; i++) {
            for(int j = 0; j < explored[0].length; j++) {
                if(!explored[i][j]) {
                    if(grid[i][j] == 1) {
                        max_area = Math.max(max_area, exploreIsland(i, j, explored, grid));
                    }
                }
                else {
                    explored[i][j] = true;
                }
            }
        }
        return max_area;
    }

    private int exploreIsland(int row, int col, boolean[][] explored, int[][] grid) {
        if(row < 0 || row >= explored.length || col < 0 || col >= explored[0].length ||
        explored[row][col]) {
            return 0;
        }
        explored[row][col] = true;
        if(grid[row][col] == 1) {
            return 1 + 
            exploreIsland(row - 1, col, explored, grid) +
            exploreIsland(row + 1, col, explored, grid) +
            exploreIsland(row, col + 1, explored, grid) +
            exploreIsland(row, col - 1, explored, grid);
        }
        return 0;
    }
}
