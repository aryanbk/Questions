class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[][] pair = new int[n][2];
        int[] set = new int[n];
        
        for(int i=0; i<n; ++i) pair[i] = new int[]{nums[i], i};
        Arrays.sort(pair, (a,b) -> a[0] - b[0]);
        for(int i=0; i<n; ++i) set[i] = findSetBit(nums[i]);
        
        for(int i=0; i<n; ++i){
            int oldIdx = pair[i][1];
            int curSet = set[oldIdx];
            
            for(int j=Math.min(oldIdx, i); j<=Math.max(oldIdx, i); ++j){
                if(set[j] != curSet) return false;
            }
        }
        
        return true;
    }
    
    int findSetBit(int num){
        int ans = 0;
        while(num > 0){
            ans += (num % 2);
            num /= 2;
        }
        return ans;
    }
}