class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        long two = 1;
        while(two<=right){
            if(two-1>=left && two<=right) return 0;
            two = two<<1;
        }
        int ans = right;
        while(left<right && ans!=0){
            ans = ans & left++;
        }
        return ans;
    }
}