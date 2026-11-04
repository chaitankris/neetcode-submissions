class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( (x,y) -> {
             int distY = y[0] * y[0] + y[1] * y[1];
             int distX = x[0] * x[0] + x[1] * x[1];
             return Integer.compare(distY, distX); 
        }  );

        for(int[] point : points){
            pq.add(point);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[][] closest = new int[k][2];

        for(int i=0; i<k; i++){
            closest[i] = pq.poll();
        }

        return closest; 

    }
}
