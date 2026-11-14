class MinStack {
    private Deque<int[]> stack;
    private int min_num;
    public MinStack() {
        stack = new ArrayDeque<>();
        min_num = Integer.MAX_VALUE;
    }
    
    // Each stack holds the current max at that point
    public void push(int val) {
        min_num = Math.min(val, min_num);
        stack.push(new int[] {val, min_num});
    }
    
    public void pop() {
        stack.pop();
        if(!stack.isEmpty()) {
            int[] temp = stack.peek();
            min_num = temp[1];
        }
        else {
            min_num = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        int[] temp = stack.peek();
        return temp[0];
    }
    
    public int getMin() {
        int[] temp = stack.peek();
        return temp[1];
    }
}
