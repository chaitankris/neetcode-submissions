class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++){
            // Skip duplicate elements for the first position
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;
            int target = -nums[i];
            // Two Sum with sorted array
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    
                    // Skip duplicates for the left and right pointers
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    
                    l++;
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
            }
        }
        }
        return ans;
    }
}
