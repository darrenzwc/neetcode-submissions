class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> cars = new TreeMap<>(Collections.reverseOrder());
        Deque<Double> fleets = new ArrayDeque<>();
        // sort position in reverse order
        for(int i = 0; i < position.length; i++) {
            cars.put(position[i], speed[i]);
        }
        // Iterate through Map and append to a stack
        for(Map.Entry<Integer, Integer> car : cars.entrySet()) {
            double time = (target - car.getKey()) / (double) car.getValue();
            if(fleets.isEmpty()|| time > fleets.peek()) {
                fleets.push(time);
            }
        }
        //Num of stacks = num of fleets;
        return fleets.size();
    }
}
