class Solution {
    public int findMin(int[] nums) {
        int start =0;
        int end = nums.length-1;
        int ans = Integer.MAX_VALUE;

        while(start<=end){
            int mid = start + (end-start)/2;
            ans = Math.min(ans, nums[mid]);

            // total array is sorted 
            if(nums[start] <= nums[mid] &&  nums[mid] <= nums[end]){
                ans = Math.min(ans, nums[start]);
            }
            // left is sorted - means search right
            if(nums[start] <= nums[mid]){
                start = mid+1;
            } // search left
            else{
                end = mid-1;
            }
            
        }

        return ans;
    }
}
