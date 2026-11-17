class Solution {
    Map<Integer, Set<Integer>> prereqs = new HashMap<>();
    Set<Integer> visited_courses = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Populate course : prereqs
        for (int[] course : prerequisites) {
            prereqs.computeIfAbsent(course[0], k -> new HashSet<>()).add(course[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course) {
        // Cycle detected
        if (visited_courses.contains(course)) {
            return false;
        }
        // No prerequisites left to check
        if (!prereqs.containsKey(course) || prereqs.get(course).isEmpty()) {
            return true;
        }

        visited_courses.add(course);

        for (int pre : prereqs.get(course)) {
            if (!dfs(pre)) {
                return false;
            }
        }

        // Remove from current DFS path and memoize as completable
        visited_courses.remove(course);
        prereqs.put(course, new HashSet<>());
        
        return true;
    }
}
