class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // the key should be a frequency for every letter
        // the value should be a list of the strings that share that
        Map<String,List<String>> anagrams = new HashMap<>();
        for(String word : strs) {
            // make key
            int[] freq = new int[26];
            for(int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                freq[index]++;
            }
            String key = Arrays.toString(freq);
            anagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        List<List<String>> result = new ArrayList<>();
        anagrams.forEach((key, value) -> {
            result.add(value);
        });
        return result;
    }
}
