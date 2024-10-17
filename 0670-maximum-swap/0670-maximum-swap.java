class Solution {
    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        int n = arr.length;
        
        char mx = arr[n-1];
        int mxIdx = n-1;
        int ans = num;
        
        for(int i=n-1; i>=0; --i){
            char cur = arr[i];
            if(cur > mx){
                mx = cur;
                mxIdx = i;
            }
            else{
                // swap, find new value, re-swap
                arr[i] = mx;
                arr[mxIdx] = cur;
                ans = Math.max(ans, Integer.parseInt(String.valueOf(arr)));
                arr[mxIdx] = mx;
                arr[i] = cur;
            }
        }
        
        return ans;
    }
}