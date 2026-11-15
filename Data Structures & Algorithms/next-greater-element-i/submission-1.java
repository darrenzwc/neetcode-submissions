class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // num : next greater 
        Map<Integer, Integer> greater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[nums1.length];
        for(int i = nums2.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                greater.put(nums2[i], -1);
            }
            else {
                greater.put(nums2[i], nums2[stack.peek()]);
            }
            stack.push(i);
        }
        for(int i = 0; i < nums1.length; i++) {
            result[i] = greater.get(nums1[i]);
        }
        return result;
    }
}