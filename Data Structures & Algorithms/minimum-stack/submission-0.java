class MinStack {

    record Pair(int val, int min) {};
    Stack<Pair> s;
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push(new Pair(val, val));
        }else {
            s.push(new Pair(val, Math.min(val, s.peek().min)));
        }
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().val;
    }
    
    public int getMin() {
        return s.peek().min;
    }
}
