class Solution {
    public int maximumSwap(int num) {
        char[] c = Integer.toString(num).toCharArray();
        // String[] ans = new String[c.length];
        char mx = c[c.length-1];
        int mxIdx = c.length-1;
        int ans = num;
        
        for(int i=c.length-1; i>=0; --i){
            char cur = c[i];
            if(cur > mx){
                mx = cur;
                mxIdx = i;
            }
            else{
                c[i] = mx;
                c[mxIdx] = cur;
                ans = Math.max(ans, Integer.parseInt(String.valueOf(c)));
                c[mxIdx] = mx;
                c[i] = cur;
            }
        }
        
        return ans;
    }
}