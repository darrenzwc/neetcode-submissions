class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() < 2) {
            return s.length();
        }
        int longestSeq = 0;
        // letter with the highest freq is not replaced within a window
        // Hashmap key = letter, val = freq

        //Track freqs
        Map<Character, Integer> freqs = new HashMap<>();
        // Valid subseq is window size - highestfrequency <= k
        int r = 0;
        int maxfreq = 0;
        for(int l = 0; l < s.length(); l++) {
            char leftChar = s.charAt(l);
            while((r - l) - maxfreq <= k) {
                longestSeq = Math.max(longestSeq, r - l);
                if(r < s.length()) {
                    char rightChar = s.charAt(r);
                    freqs.put(rightChar, freqs.getOrDefault(rightChar, 0) + 1);
                    maxfreq = Math.max(maxfreq, freqs.get(rightChar));
                    r++;
                }
                else {
                    break;
                }
            }
            freqs.put(leftChar, freqs.getOrDefault(leftChar, 0) - 1);
        }
        return longestSeq;
    }
}
