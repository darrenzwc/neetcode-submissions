class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // 1. Sort to group duplicates
        findCombination(0, candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private void findCombination(int index, int[] candidates, int target, List<Integer> cmb, int sum) {
        if (target == sum) {
            result.add(new ArrayList<>(cmb));
            return;
        }
        // 2. Continue only while sum is strictly less than target
        if (sum < target) {
            for (int i = index; i < candidates.length; i++) {
                // 3. Skip duplicate elements at the same recursion depth
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }       
                // Optional optimization: stop early since the array is sorted
                if (sum + candidates[i] > target) {
                    break;
                }

                cmb.add(candidates[i]);
                sum += candidates[i];
                
                // 4. Pass i + 1 so each element is used at most once
                findCombination(i + 1, candidates, target, cmb, sum);
                
                cmb.remove(cmb.size() - 1);
                sum -= candidates[i];
            }
        }
    }
}