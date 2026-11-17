class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        Set<Character> substring = new HashSet<>();
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            while(substring.contains(s.charAt(right))) {
                substring.remove(s.charAt(left));
                left++;
            }
            substring.add(s.charAt(right));
            longest = Math.max(longest, substring.size());
        }
        return longest;
    }
}
