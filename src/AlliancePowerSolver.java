public class AlliancePowerSolver {

    public int findKthHighestPower(int[][] alliance_power, int k) {
        int n = alliance_power.length;
        int low = 1;
        int high = 1000000;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countGreaterThanOrEqual(alliance_power, mid);
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

    // 主函数用于测试
    public static void main(String[] args) {
        AlliancePowerSolver solver = new AlliancePowerSolver();

        // 示例测试
        int[][] alliance_power = {
                {5, 4, 3},
                {4, 3, 2},
                {3, 2, 1}
        };
        int k = 3;

        int result = solver.findKthHighestPower(alliance_power, k);
        System.out.println("第 " + k + " 高的战力值是: " + result);
    }
}