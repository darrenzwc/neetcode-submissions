class Solution {
    public int orangesRotting(int[][] grid) {
        // impossible state is an isolated fruit or no rotten fruit
        int fruit = 0;
        Queue<int[]> rotten = new ArrayDeque<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                fruit += grid[i][j] == 1 ? 1 : 0;
                if(grid[i][j] == 2) {
                    rotten.add(new int[]{i, j});
                }
            }
        }
        int time = 0;
        while(!rotten.isEmpty() && fruit > 0) {
            int size = rotten.size();
            for(int i = 0; i < size; i++) {
                int[] currFruit = rotten.poll();
                int row = currFruit[0];
                int col = currFruit[1];
                if(row != 0 && grid[row - 1][col] == 1) {
                    fruit--;
                    grid[row - 1][col] = 2;
                    rotten.add(new int[]{row - 1, col});
                }
                if(row != grid.length - 1 && grid[row + 1][col] == 1) {
                    fruit--;
                    grid[row + 1][col] = 2;
                    rotten.add(new int[]{row + 1, col});
                }
                if(col != 0 && grid[row][col - 1] == 1) {
                    fruit--;
                    grid[row][col - 1] = 2;
                    rotten.add(new int[]{row, col - 1});
                }
                if(col != grid[0].length - 1 && grid[row][col + 1] == 1) {
                    fruit--;
                    grid[row][col + 1] = 2;
                    rotten.add(new int[]{row, col + 1});
                }
            }
            time++;
        }
        return fruit == 0 ? time : -1;
    }
}
