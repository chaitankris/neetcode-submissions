class Solution {

    // Here the binary search space is on the hour rate 
    public int minEatingSpeed(int[] piles, int h) {
        int max= Integer.MIN_VALUE;
        int min = 1;
        int ans = 0;
        for(int i=0; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }

        while(min<=max){
            int mid = min + (max-min)/2;
            if(calculate(piles, h, mid)){
                ans = mid;
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }

        return ans;

    }

    public boolean calculate(int[] piles, int h, int val){
        long sum=0;
        for(int i: piles){
            sum += (long) Math.ceil((double) i/val);
        }

        return h>=sum;
    }
}
