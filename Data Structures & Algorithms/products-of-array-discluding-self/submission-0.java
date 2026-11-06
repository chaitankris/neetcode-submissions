class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] rightProd = new int[n];
        int[] leftProd = new int[n];
        int[] res = new int[n];
        leftProd[0] = 1;
        rightProd[n-1] = 1;
        for(int i=1; i<n; i++){
            leftProd[i] = leftProd[i-1] * nums[i-1];
            rightProd[n-i-1] = rightProd[n-i] * nums[n-i]; 
        }

        for(int i=0; i<n; i++){
            res[i] = leftProd[i] * rightProd[i];
        }

        return res;
    }
}  
