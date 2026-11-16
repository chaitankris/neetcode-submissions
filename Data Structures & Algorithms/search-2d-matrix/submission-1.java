class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // row position
            int rp = mid / col;
            // col position 
            // cp = mid % col (can be done using % operator )
            int cp = mid - rp * col;

            if (matrix[rp][cp] == target) {
                return true;
            } else if (matrix[rp][cp] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
