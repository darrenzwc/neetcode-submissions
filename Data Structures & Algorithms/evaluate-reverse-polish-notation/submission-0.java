class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        String operations = "+-*/";
        for(String token : tokens) {
            if(operations.contains(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(calc(num1, num2, token));
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
        
    }

    private int calc(int num1, int num2, String op) {
        switch(op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        return -1;
    }
}
