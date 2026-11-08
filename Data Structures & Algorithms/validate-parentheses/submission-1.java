class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if(c == ')' || c == '}' || c == ']' ) {
                if(stack.isEmpty() || map.get(c) != stack.peek()){
                    return false;
                }
                stack.pop();
            }
            else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}
