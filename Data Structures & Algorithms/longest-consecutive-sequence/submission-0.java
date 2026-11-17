class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i: nums){
            map.put(i, false);
        }
        int ans = 1;
        for(int i=0; i<nums.length; i++){
            if(map.get(nums[i]) == false){
                map.put(nums[i], true);
                int x=1+nums[i];
                int cur = 1;
                while(map.containsKey(x)){
                    map.put(x, true);
                    cur++;
                    x+=1;
                }
                ans = Math.max(ans, cur);
            }
        }

        return ans;
    }
}
