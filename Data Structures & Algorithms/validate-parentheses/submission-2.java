class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        if(s.length() == 1) {
            return false;
        }
        String open = "({[";
        String closed = ")}]";
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(closed.contains(String.valueOf(ch)) && stack.isEmpty()) {
                return false;
            }
            if(open.contains(String.valueOf(ch))) {
                stack.push(ch);
            }
            else if(stack.peek() == '(' && ch == ')' ||
                    stack.peek() == '{' && ch == '}' ||
                    stack.peek() == '[' && ch == ']') {
                stack.pop();
            } 
            else {
                return false;
            }
        }  
        return stack.isEmpty();
    }
}
