class Solution {
    public int lastStoneWeight(int[] stones) {
        // Hold a heap for the stone
        // Grab the top 2 values every time (remove from pq)
        // If equals 0 move on, else append the left over back to the heap
        // We want max heap so descending order
        PriorityQueue<Integer> heaviestStones = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones) {
            heaviestStones.add(stone);
        }
        while(heaviestStones.size() > 1) {
            int y = heaviestStones.remove();
            int x = heaviestStones.remove();
            if(x < y) {
                heaviestStones.add(y - x);
            }
        }
        return heaviestStones.size() == 1 ? heaviestStones.poll() : 0;
    }
}
