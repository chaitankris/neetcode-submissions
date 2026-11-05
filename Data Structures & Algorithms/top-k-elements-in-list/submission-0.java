class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        record Pair(int freq, int val) {};
        HashMap<Integer, Integer> map = new HashMap<>();
        // frequency Map
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>( (x,y) -> { return Integer.compare(x.freq, y.freq); });
        for(var e : map.entrySet() ){
            pq.add(new Pair(e.getValue(), e.getKey() ));
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] res = new int[k];

        for(int i=0; i<k; i++){
            res[i] = pq.poll().val;
        }

        return res;
    }
}
