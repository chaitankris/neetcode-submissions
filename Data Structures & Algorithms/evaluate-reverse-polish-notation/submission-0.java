class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> s = new Stack<>();
        for(int i=0; i<tokens.length; i++){
            if(tokens[i].equals("*") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("+")) {
                int right = s.pop();
                int left = s.pop();
                int res;
                switch(tokens[i]) {
                    case "*":
                        res = left * right;
                        break;
                    case "+":
                        res = left + right;
                        break;
                    case "-":
                        res = left - right;
                        break;
                    case "/":
                        res = left / right;
                        break;
                    default:
                        continue;
                }
                s.push(res);
            }else {
                s.push(Integer.parseInt(tokens[i]));
            }
        }

        return s.peek();
    }
}
