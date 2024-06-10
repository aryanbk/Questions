class Solution {
    public int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        Arrays.sort(sorted);
        int ans = 0;
        int n = sorted.length;
        ans = (int) IntStream.range(0, n).filter(i -> sorted[i] != heights[i]).count();
        return ans;
    }
}
