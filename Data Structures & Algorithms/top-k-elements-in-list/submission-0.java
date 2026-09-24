class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Time complexity O(N)
        // Array freq = [1, 3, 5, 7, 9]
        // Array possible elements [all freqs from 1 - k][n]
        // index related to the frequency. Get last k elements
        Map<Integer, Integer> freq_map = new HashMap<>();
        // O(N) tracks the freq for every unique num
        for(int num : nums) {
            freq_map.put(num, freq_map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length];
        // O(N) 
        // key = unique num
        // value = frequency
        freq_map.forEach((key, value) -> {
            int index = value - 1;
            if(bucket[index] == null) {
                bucket[index] = new ArrayList<>();
            }
            bucket[index].add(key);
        });
        // get the top k
        int[] result = new int[k];

        int bucket_index = bucket.length - 1;
        int curr_freq = 0;
        while(k > 0) {
            // make sure bucket is not empty
            // haven't reached end of the bucket
            if(bucket[bucket_index] == null ||
                curr_freq > bucket[bucket_index].size() - 1) {
                bucket_index--;
                curr_freq = 0;
            }
            else {
                result[result.length - k] = bucket[bucket_index].get(curr_freq);
                k--;
                curr_freq++;
            }
        }
        return result;
    }
}
