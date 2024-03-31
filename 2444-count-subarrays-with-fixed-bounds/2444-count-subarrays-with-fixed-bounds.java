class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        Deque<Integer> dq1 = new LinkedList<>();
        Deque<Integer> dq2 = new LinkedList<>();
        int mx = 0;
        int mxI = -1;
        int mn = 100000000;
        int mnI = -1;
        long ans = 0;
        
        for(int l=0, r=0; r<nums.length; ++r){
            while(!dq1.isEmpty() && dq1.peekLast() < nums[r])
                dq1.pollLast();
            while(!dq2.isEmpty() && dq2.peekLast() > nums[r])
                dq2.pollLast();
            dq1.offerLast(nums[r]);
            dq2.offerLast(nums[r]);
            
            if(nums[r] == maxK) mxI = r;
            if(nums[r] == minK) mnI = r;
            mx = Math.max(mx, nums[r]);
            mn = Math.min(mn, nums[r]);
            
            if(mn<minK || mx>maxK){
                mx = 0;
                mn = 1000000000;
                dq1 = new LinkedList<>();
                dq2 = new LinkedList<>();
                l = r+1;
            }
            if(mn == minK && mx == maxK)
                ans += (long) Math.min(mnI, mxI)-l + 1;
        }
        
        return ans;
    }
}