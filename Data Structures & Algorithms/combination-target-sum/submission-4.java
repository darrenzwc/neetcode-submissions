class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // From each sum starting point I can choose a number in each list
        //      sum = 0
        //      2       5       6       9
        //   2 5 6 9  2 5 6 9 
        addNum(new ArrayList<>(), 0, 0,target, nums);
        return result;
    }

    private void addNum(List<Integer> sumList, int sum, int index, int target, int[] nums) {
        if(sum == target) {
            result.add(new ArrayList<>(sumList));
        }
        else if(sum < target) {
            for(int i = index; i < nums.length; i++) {
                if(sum + nums[i] <= target) {
                    sumList.add(nums[i]);
                    addNum(sumList, sum + nums[i], i, target, nums);
                    sumList.remove(sumList.size() - 1);
                }
            }
        }
    }
}
