class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> req_freq = new HashMap<>();
        Map<Character, Integer> curr_freq = new HashMap<>();
        int minIndex = -1;
        int minLen = Integer.MAX_VALUE;

        // get required substring map
        // for(char ch : t.toCharArray())
        for(char ch : t.toCharArray()) {
            req_freq.put(ch, req_freq.getOrDefault(ch, 0) + 1);
        }
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            char currLetter = s.charAt(r);
            if(req_freq.containsKey(currLetter)) {
                curr_freq.put(currLetter, curr_freq.getOrDefault(currLetter, 0) + 1);
            }
            while(isValid(curr_freq, req_freq)) {
                if(r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minIndex = l;
                }
                char lastLetter = s.charAt(l);
                if(curr_freq.containsKey(lastLetter)) {
                    curr_freq.put(lastLetter, curr_freq.get(lastLetter) - 1);
                }
                l++;
            }
        }
        return minIndex == -1 ? "" : s.substring(minIndex, minIndex + minLen);
    }
    private boolean isValid(Map<Character, Integer> curr, Map<Character, Integer> req) {
        for(Map.Entry<Character, Integer> freq : req.entrySet()) {
            if(!curr.containsKey(freq.getKey()) || curr.get(freq.getKey()) < freq.getValue()) {
                return false;
            }
        }
        return true;
    }
}
