class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // We know to stop when num is greater than target
        int[] result = new int[2];
        // smallest and largest
        int start = 0;
        int end = numbers.length - 1;
        boolean foundSum = false;
        while(!foundSum) {
            int sum = numbers[start] + numbers[end];
            if(sum == target) {
                foundSum = true;
            }
            else if(sum > target) {
                end--;
            }
            else {
                start++;
            }
        }
        result[0] = start + 1;
        result[1] = end + 1;
        return result;
    }
}
