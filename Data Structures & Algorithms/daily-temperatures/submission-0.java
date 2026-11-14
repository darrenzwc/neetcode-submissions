class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for(int i = temperatures.length - 1; i >= 0; i--) {
            int temp = temperatures[i];
            int days = 0;
            while(!stack.isEmpty() && temp >= temperatures[stack.peek()]) {
                stack.pop();
            }
            days = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
            result[i] = days;
        }
        return result;
    }
}
