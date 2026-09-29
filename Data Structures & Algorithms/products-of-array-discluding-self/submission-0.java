class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result =  new int[nums.length];
        int product = 1;
        int indexZ = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if(indexZ != -1) {
                    return result;
                }
                indexZ = i;
            }
            else {
                product *= nums[i];
            }
        }
        // zero edge-case
        if(indexZ != -1) {
            result[indexZ] = product;
            return result;
        }
        for(int i = 0; i < nums.length; i++) {
            result[i] =  product / nums[i];
        }
        return result;   
    }
}  
