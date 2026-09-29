class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        while(low <= high) {
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > nums[high]) {
                if(target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            mid = (low + high) / 2;
        }
        return -1;
    }
}
