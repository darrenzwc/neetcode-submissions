class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Hold one value and then iterate across with the 2 sums w/2x ptr
        // sort array for optimal time
        Set<List<Integer>> result = new HashSet<>();
        // Time Complexity O(nLogN) where n is the number of ints in nums
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int sum = 0;
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                sum = nums[i] + nums[start] + nums[end];
                if(sum == 0) {
                    result.add(new ArrayList<Integer>(List.of(nums[i], nums[start], nums[end])));
                    start++;
                    end--;
                }
                else if(sum > 0) {
                    end--;
                }
                else {
                    start++;
                }
            }
        }
        return new ArrayList<>(result);


        
    }
}
