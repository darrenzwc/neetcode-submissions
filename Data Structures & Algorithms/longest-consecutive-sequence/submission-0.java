class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        int longest = 0;
        for(int num : nums) {
            uniqueNums.add(num);
        }
        // find candidacy
        for(int num : uniqueNums) {
            if(!uniqueNums.contains(num - 1)) {
                int currNum = num;
                int currLongest = 0;
                boolean validSeq = true;
                while(validSeq) {
                    currLongest++;
                    currNum++;
                    validSeq = uniqueNums.contains(currNum);
                }
                longest = Math.max(longest, currLongest);
            }
        }
        return longest;
    }
}
