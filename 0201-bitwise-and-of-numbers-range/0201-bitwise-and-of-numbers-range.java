class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        long two = 1;
        
        while(two<=right){
            if(two-1>=left && two<=right) return 0;
            two <<= 1;
        }
        
        int ans = right;
        while(left<right && ans!=0) ans &= left++;
        return ans;
    }
}