class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        int[] freq = new int[101];
        for(int x: nums) ++freq[x];
        
        int ans = 0;
        int mx = -1;
        
        for(int i=0; i<freq.length; ++i){
            if(freq[i]==mx) ++ans;
            else if(freq[i]>mx){
                mx=freq[i];
                ans = 1;
            }
        }
        return ans*mx;
    }
}