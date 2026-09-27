class Solution {
    public int lengthOfLongestSubstring(String s) {
        // keep track of the max amount 
        // sliding window, when left is increased we remove from set
        // when the right is increased add to set
        // Hashset, add/remove/contains O(1) unique elements
        int start = 0;
        int end = 0;
        int maxLength = 0;  
        if(s.length() == 1) {
            return 1;
        }
        Set<Character> substring = new HashSet<>();
        while(end < s.length()) {
            // Not valid so must shift window until the value no longer exists.
            while(substring.contains(s.charAt(end))) {
                substring.remove(s.charAt(start));
                start++;
            }
            // The substring is now valid
            substring.add(s.charAt(end));
            maxLength = Math.max(maxLength, substring.size());
            end++;
        }
        return maxLength;      
    }
}
