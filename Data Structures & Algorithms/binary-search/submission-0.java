class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1, mid =0;
        int ans = -1;
        while(l<=r){
             mid = l+(r-l)/2;
            if(nums[mid] == target){
                ans = mid;
                return ans;
            }else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return ans;
    }
}
