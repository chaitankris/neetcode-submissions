class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        record Pair(int p, int s){};
        int n = speed.length;
        Pair[] pairs = new Pair[n];
        for(int i=0; i<n; i++){
           // Initialize each element with a new Pair instance using the constructor
           pairs[i] = new Pair(position[i], speed[i]);
        }

        // sorting based on positions in decending
        Arrays.sort(pairs, (x,y) -> { return Integer.compare(y.p,x.p); });

        //Use monotonic stack; 
        Stack<Pair> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            if(stack.isEmpty()){
                stack.push(pairs[i]);
                continue;
            }
            double topTime = (double) (target - stack.peek().p())/(stack.peek().s());
            double curTime = (double) (target - pairs[i].p())/(pairs[i].s());

            if(topTime < curTime) {
                stack.push(pairs[i]);
            }
        }

        return stack.size();
    }
}
