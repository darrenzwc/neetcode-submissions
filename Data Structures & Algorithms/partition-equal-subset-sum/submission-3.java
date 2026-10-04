class Solution {
    public boolean canPartition(int[] nums) {
        // Use a set to store all of our sums
        // Hashset O(1) retrieval, manipulation
        int totalSum = 0; 
        for(int num : nums) {
            totalSum += num;
        }
        if(totalSum % 2 != 0) {
            return false;
        }
        int target = totalSum / 2;
        
        Set<Integer> allSums = new HashSet<>();
        // base case: empty group
        allSums.add(0);
        for(int num : nums) {
            Set<Integer> tempSum = new HashSet<>();
            for(int sum : allSums) {
                int newSum = num + sum;
                if(newSum == target) {
                    return true;
                }
                if(newSum < target) {
                    tempSum.add(num + sum);
                }
            }
            allSums.addAll(tempSum);
        }
        return false;
    }
}
