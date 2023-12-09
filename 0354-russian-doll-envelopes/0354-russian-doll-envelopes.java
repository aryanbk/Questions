class Solution {
    public int maxEnvelopes(int[][] evlp) {
        Arrays.sort(evlp, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // If widths are same, sort heights in descending order
            }
            return a[0] - b[0];
        });
        return lengthOfLIS(evlp);
    }
    
    public int lengthOfLIS(int[][] nums) {
        int len = 0;
        for (int n[]: nums) {
            if (len == 0 || nums[len - 1][1] < n[1])
                nums[len++] = n;
            else
                nums[bsLowerBound(0, len - 1, n[1], nums)] = n;
        }
        return len;
    }

    private int bsLowerBound(int left, int right, int x, int[][] nums) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid][1] >= x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}