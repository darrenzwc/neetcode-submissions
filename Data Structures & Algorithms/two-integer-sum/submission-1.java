class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complement = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            complement.put(target - nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            if(complement.containsKey(nums[i]) && complement.get(nums[i]) != i) {
                return new int[]{Math.min(i, complement.get(nums[i])), Math.max(i, complement.get(nums[i]))};
            }
        }
        return null;
    }
}
