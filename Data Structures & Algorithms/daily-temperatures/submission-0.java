class Solution {

    record Pair(int temp, int idx){};
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> s = new Stack();
        int n = temperatures.length;
        int[] res = new int[n];
        res[n-1] = 0;
        s.add(new Pair(temperatures[n-1], n-1));
        for(int i=n-2; i>=0; i--){
            while(!s.isEmpty() && temperatures[i]>=s.peek().temp){
                s.pop();
            }
            res[i] = s.isEmpty() ? 0 : s.peek().idx - i;
            s.add(new Pair(temperatures[i], i));
        }

        return res;
    }
}
