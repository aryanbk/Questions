class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int n = height.length;
        for(int l=0, r=n-1; l<r;){
            int area = Math.min(height[l], height[r]) * (r-l);
            ans = Math.max(ans, area);
            if(height[l]<height[r]) ++l;
            else --r;
        }
        return ans;
    }
}