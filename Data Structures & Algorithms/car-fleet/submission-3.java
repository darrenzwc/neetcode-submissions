class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Position : Speed
        Map<Integer, Integer> cars = new TreeMap<>(Collections.reverseOrder());
        Deque<Double> stack = new ArrayDeque<>();

        for(int i = 0; i < position.length; i++) {
            cars.put(position[i], speed[i]);
        }

        cars.forEach((pos, v) -> {
            double time = (double) (target - pos) / v;
            if(stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        });

        return stack.size();

    }
}
