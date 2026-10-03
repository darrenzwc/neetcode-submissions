class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        // get centers
        if(s.length() == 1) {
            return s;
        }
        for(int i = 0; i < s.length() - 1; i++) {
            String oddPalindrome = findPalindrome(i, i, s);
            String evenPalindrome = "";
            if(s.charAt(i) == s.charAt(i + 1)) {
                evenPalindrome = findPalindrome(i, i + 1, s);
            }
            String bestPalindrome = oddPalindrome.length() > evenPalindrome.length() ? 
                        oddPalindrome : evenPalindrome;
            longest = longest.length() > bestPalindrome.length() ? longest : bestPalindrome;
        }
        return longest;
    }
    private String findPalindrome(int left, int right, String s) {
        while(left - 1 != -1 && 
            right + 1 != s.length() && s.charAt(left - 1) == s.charAt(right + 1)) {
            left--;
            right++;
        }
        return s.substring(left, right + 1);
    }
}
