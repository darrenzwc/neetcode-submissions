class Solution {
    public int findKthLargest(int[] nums, int k) {
        // max-heap method
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums) {
            heap.add(num);
        }
        int kth = 0;
        for(int i = 0; i < k; i++) {
            kth = heap.poll();
        }
        return kth;
    }
}
