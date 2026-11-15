class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(target == nums[mid]) {
                return mid;
            }
            // Left side is sorted 
            if(nums[low] <= nums[mid]) {
                // if tgt exists in the left side
                if(target >= nums[low] && 
                        target <= nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            // check right side sorted
            else if(nums[mid] <= nums[high]) {
                // if tgt exists in right side
                if(target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }

            }
        }
        return -1;
    }
}
