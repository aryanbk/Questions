class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank[0].length();
        int ans = 0;
        int last = 0;
        
        for(String row: bank){
            int cur = 0;
            for(int j=0; j<n; ++j)
                cur += row.charAt(j)=='1' ? 1 : 0;
            ans += last*cur;
            if(cur != 0) last = cur;
        }
        
        return ans;
    }
}