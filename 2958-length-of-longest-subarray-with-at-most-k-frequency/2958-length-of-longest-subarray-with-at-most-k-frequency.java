class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int mx = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for(int l=0, r=0; r<nums.length; ++r){
            int right = nums[r];
            map.put(nums[r], map.getOrDefault(right, 0)+1);
            int curFreq = map.get(right);
            
            freq.put(curFreq, freq.getOrDefault(curFreq, 0)+1);
            freq.put(curFreq-1, freq.getOrDefault(curFreq-1, 0)-1);
            
            mx = Math.max(curFreq, mx);
            
            while(l<=r && mx > k){
                int left = nums[l];
                int lFreq = map.get(left);
                map.put(left, map.get(left) - 1);
                
                freq.put(lFreq, freq.get(lFreq) - 1);
                freq.put(lFreq-1, freq.get(lFreq-1) + 1);
                
                if(lFreq == mx) --mx;
                
                ++l;
            }

            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}