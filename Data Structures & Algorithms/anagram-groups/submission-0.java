class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();
        int size = 0;
        for(String word : strs) {
            char[] temp = word.toCharArray();
            Arrays.sort(temp);
            String anagram = new String(temp);
            if(!dict.containsKey(anagram)) {
                dict.put(anagram, new ArrayList<String>());
                size++;
            }
            dict.get(anagram).add(word);
        }
        return new ArrayList<>(dict.values());
    }
}
