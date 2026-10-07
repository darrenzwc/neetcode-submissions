class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // edge case
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> current = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }

        int l = 0;

        for (int r = 0; r < s2.length(); r++) {
            char right = s2.charAt(r);
            current.put(right, current.getOrDefault(right, 0) + 1);

            // Keep the window at most s1.length() characters long
            if (r - l + 1 > s1.length()) {
                char left = s2.charAt(l);
                current.put(left, current.get(left) - 1);
                l++;
            }

            if (r - l + 1 == s1.length()
                    && isPermutation(current, target)) {
                return true;
            }
        }

        return false;
}
    private boolean isPermutation(Map<Character, Integer> current, Map<Character, Integer> target) {
        for(Map.Entry<Character, Integer> entry : target.entrySet()) {
            if(!current.containsKey(entry.getKey()) ||
                !current.get(entry.getKey()).equals(entry.getValue())) {
                    return false;
            }
        }
        return true;
    }
}
