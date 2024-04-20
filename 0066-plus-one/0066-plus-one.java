class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;
        for(int i=n-1; i>=0; --i){
            digits[i] += carry;
            carry = digits[i]/10;
            digits[i] %= 10;
        }
        if(carry == 0) return digits;
        int[] ans = new int[n+1];
        ans[0] = carry;
        for(int i=1; i<n+1; ++i) ans[i] = digits[i-1];
        return ans;
    }
}