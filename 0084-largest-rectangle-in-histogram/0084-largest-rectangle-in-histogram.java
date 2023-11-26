class Solution {
    public int largestRectangleArea(int[] hts) {
        int ans = 0;
        int n = hts.length;

        int[] left = nearestSmallToLeft(hts);
        int[] right = nearestSmallToRight(hts);

        for (int i = 0; i < n; ++i) {
            int newArea = hts[i] * (right[i] - left[i] - 1); // Calculate the area for each rectangle
            ans = Math.max(ans, newArea); // Update the maximum area found
        }
        return ans;
    }

    private int[] nearestSmallToRight(int[] h) {
        int n = h.length;
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && h[stk.peek()] >= h[i])
                stk.pop();
            ans[i] = stk.isEmpty() ? n : stk.peek();
            stk.push(i);
        }
        return ans;
    }

    private int[] nearestSmallToLeft(int[] h) {
        int n = h.length;
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {
            while (!stk.isEmpty() && h[stk.peek()] >= h[i])
                stk.pop();
            ans[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }
        return ans;
    }
}
