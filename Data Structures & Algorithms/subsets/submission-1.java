class Solution {
    public static void generateSubsets(int[] nums, int startIndex, List<Integer> currList, List<List<Integer>> output) {
        if (startIndex == nums.length) {
            output.add(new ArrayList<>(currList));
            return;
        }
        currList.add(nums[startIndex]);
        generateSubsets(nums, startIndex + 1, currList, output);
        currList.removeLast();
        generateSubsets(nums, startIndex + 1, currList, output);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList();
        generateSubsets(nums, 0, new ArrayList(), subsets);
        return subsets;
    }
}
