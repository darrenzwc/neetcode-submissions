class KthLargest {
    private PriorityQueue<Integer> stream;
    private int kth;
    public KthLargest(int k, int[] nums) {
        stream = new PriorityQueue<>();
        kth = k;
        for(int num : nums) {
            addStream(num);
        }
    }
    
    public int add(int val) {
        addStream(val);
        return stream.peek();
    }

    private void addStream(int num) {
        stream.add(num);
        if(stream.size() > kth) {
            stream.remove();
        }
    }
}
