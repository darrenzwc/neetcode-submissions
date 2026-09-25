class Solution {
    public boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;

        while(head < tail) {
            char headC = s.charAt(head);
            char tailC = s.charAt(tail);
            if(!Character.isLetterOrDigit(headC)) {
                head++;
            }
            else if(!Character.isLetterOrDigit(tailC)) {
                tail--;
            }
            else if(Character.toLowerCase(headC) != Character.toLowerCase(tailC)) {
                return false;
            }
            else {
                head++;
                tail--;
            }
        }
        return true;
    }
}
