class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        while(low < high) {
            if(nums[low] > nums[mid]) {
                high = mid; 
            }
            else if(nums[mid] > nums[high]) {
                low = mid + 1;
            }
            else {
                return nums[low];
            }
            mid = (low + high) / 2;
        }
        return nums[mid];
    }
}
