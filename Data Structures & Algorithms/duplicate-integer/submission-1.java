class Solution {
    public boolean hasDuplicate(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int num : nums) {
            if(result.contains(num)) {
                return true;
            }
            else {
                result.add(num);
            }
        }
        return false;
    }
}