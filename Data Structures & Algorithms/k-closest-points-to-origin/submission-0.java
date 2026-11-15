class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // A min-heap that stores the distances of all the points calc w/formula
        // return the top-k points
        // Store as a hash-map for easy retrieval
        // Mapping: Distance -> coordinate
        record Point(int[] coordinate, double distance) {};
        PriorityQueue<Point> minPoints = new PriorityQueue<>(Comparator.comparing(Point::distance));
        int[][] result = new int[k][2];

        // populate calc euclidian distances and add to heap O(NlogN)
        for(int[] coordinate : points) {
            double x = coordinate[0];
            double y = coordinate[1];
            double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            Point pt = new Point(coordinate, distance);
            minPoints.add(pt);
        }

        // get min-k points and add to results
        for(int i = 0; i < k; i++) {
            Point pt = minPoints.remove();
            int[] coordinate = pt.coordinate;
            result[i][0] = coordinate[0];
            result[i][1] = coordinate[1];
        }

        return result;
    }
}
