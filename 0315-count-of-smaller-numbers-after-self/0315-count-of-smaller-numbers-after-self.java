class Solution {
    
    int[] bit;
    int n;
    
    public List<Integer> countSmaller(int[] nums) {
        n = nums.length;
        bit = new int[n+1];
        int[][] numsPair = new int[n][2]; // {num, idx} pair
        
        for(int i=0; i<n; ++i) numsPair[i] = new int[]{nums[i], i};
        Arrays.sort(numsPair, (a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        
        Integer[] ans = new Integer[n];
        for(int i=0; i<n; ++i){
            update(numsPair[i][1]+1, 1);
            ans[numsPair[i][1]] = sumQuery(n) - sumQuery(numsPair[i][1]+1);
        }
        
        return Arrays.asList(ans);
    }
    
    
    // Fenwick Tree
    // index starts at 1
    
    void update(int i, int val){
        for(; i<=n; i += (i & -i))
            bit[i] += val;
    }
    
    int sumQuery(int i){
        int ans = 0;
        for(; i>0; i -= (i & -i))
            ans += bit[i];
        return ans;
    }
    
}