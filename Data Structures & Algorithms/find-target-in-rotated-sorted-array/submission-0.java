class Solution {
    public int search(int[] nums, int target) {
        int l =0, r = nums.length - 1;
        int ans = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                ans = mid;
                break;
            }

            // left sorted
            if( nums[l] <= nums[mid]){
                //if the target is lesser the left most we need to move to right search
                if(nums[mid] < target || target < nums[l]){
                    l = mid +1;
                }else{
                    r = mid - 1;
                }
            } // right sorted 
            else{
                //if the target is greater the right most we need to move to left search
                if(target < nums[mid] || target > nums[r]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }

        return ans;
    }
}
