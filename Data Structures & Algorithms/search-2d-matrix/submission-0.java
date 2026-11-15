class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        int elementNum = m * n;
        while(low <= high) {
            int mid = (low + high) / 2;
            int midNum = matrix[mid / n][mid % n];
            if(target == midNum) {
                return true;
            }
            if(target > midNum) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return false;
    }
}
