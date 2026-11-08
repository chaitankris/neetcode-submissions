class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        helper(0,nums, new ArrayList());
        return ans;

    }

    public void helper(int start, int[] nums, List<Integer> temp){
        // Every current list is a valid subset
        ans.add(new ArrayList(temp));
        
        for(int i=start; i<nums.length; i++){
            temp.add(nums[i]);
            helper( i+1, nums, temp);
            temp.removeLast();
        }
    }

}
