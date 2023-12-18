class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
            return 1;
        
        int ans = 9;
        for(int i=0; i<n-1; ++i)
            ans *= (9-i);
        
        return ans + countNumbersWithUniqueDigits(n-1);
    }
}