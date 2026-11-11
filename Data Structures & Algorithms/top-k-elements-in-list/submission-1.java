class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        int[] result = new int[k];
        for(int num : nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }
        // Turn into bucket
        ArrayList<Integer>[] bucket = new ArrayList[nums.length];
        freqs.forEach((num, freq) -> {
            int index = freq - 1;
            if(bucket[index] == null) {
                bucket[index] = new ArrayList<>(); 
            }
            bucket[index].add(num);
        });
        int index = bucket.length - 1;
        int bucket_index = 0;
        while(k > 0) {
            if(bucket[index] == null || 
            bucket_index > bucket[index].size() - 1) {
                index--;
                bucket_index = 0;
            }
            else {
                result[result.length - k] = bucket[index].get(bucket_index);
                bucket_index++;
                k--;
            }
        }
        return result;
    }
}
