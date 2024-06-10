class Solution {
    public int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        Arrays.sort(sorted);
        return (int) IntStream.range(0, heights.length)
            .filter(i -> sorted[i] != heights[i])
            .count();
    }
}
