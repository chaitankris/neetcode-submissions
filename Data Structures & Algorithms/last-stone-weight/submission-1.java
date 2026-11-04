class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> Integer.compare(y, x));

        for(int i: stones){
            pq.add(i);
        }

        while(pq.size()>=2){
            int x = pq.poll();
            int y = pq.poll();

            if(x == y) {
                pq.add(0);
            }else if( x> y){
                pq.add(x-y);
            }else {
                pq.add(y-x);
            }
        }

        return pq.poll();
    }
}
