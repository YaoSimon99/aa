class Solution {
    public int kthGreatest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = 1;
        int high = 1000000;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countGreaterThanOrEqual(matrix, mid);
            if (count >= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    private int countGreaterThanOrEqual(int[][] matrix, int target) {
        int n = matrix.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += countInRow(matrix[i], target);
        }
        return count;
    }

    private int countInRow(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        int ans = row.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] < target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}