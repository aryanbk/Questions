class Solution {
    public int maximalRectangle(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        
        int[] newMat =  new int[n];
        
        for(int i=0; i<m; ++i){
            int[] temp = new int[n];
            for(int j=0; j<n; ++j){
                if(newMat[j] != 0 && mat[i][j] != '0')
                    temp[j] = newMat[j] + 1;
                else
                    temp[j] = mat[i][j] - '0';
            }
            newMat = temp;
            ans = Math.max(ans, largestRectangleArea(newMat));
        }

        return ans;
    }

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