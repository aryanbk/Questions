class Solution {
    
    int[] bit;
    public List<Integer> countSmaller(int[] nums) {
        bit = new int[nums.length+1];
        int[][] nums2 = new int[nums.length][2];
        for(int i=0; i<nums.length; ++i) nums2[i] = new int[]{nums[i], i};
        Arrays.sort(nums2, (a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        
        Integer[] ans = new Integer[nums.length];
        for(int i=0; i<nums.length; ++i){
            update(nums2[i][1]+1, 1);
            ans[nums2[i][1]] = query(nums.length) - query(nums2[i][1]+1);
        }
        
        return Arrays.asList(ans);
    }
    
    void update(int i, int val){
        while(i<=bit.length-1){
            bit[i] += val;
            i += (i & -i);
        }
    }
    
    int query(int i){
        int ans = 0;
        while(i>0){
            ans += bit[i];
            i -= (i & -i);
        }
        return ans;
    }
    
}