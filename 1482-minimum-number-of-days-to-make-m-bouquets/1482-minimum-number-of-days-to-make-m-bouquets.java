class Solution {
    public int minDays(int[] bloom, int m, int k) {
        int n = bloom.length;
        int[] mx = maxSlidingWindow(bloom, k);
        
        int lo = 1;
        int hi = 1000000000;
        int ans = -1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(valid(mx, mid, k, m)){
                ans = mid;
                hi = mid - 1;
            }
            else
                lo = mid + 1;
        }
        
        return ans;
        
        
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        
        for(int l=0, r=0; r<nums.length; ++r){
            while(dq.size()>0 && dq.getLast() < nums[r])
                dq.removeLast();
            dq.addLast(nums[r]);
            
            if(r-l+1 == k){
                int windowMx = dq.getFirst();
                ans[l] = windowMx;
                if(nums[l] == windowMx)
                    dq.removeFirst();
                ++l;
            }
        }
        return ans;
    }
    
    
    
    boolean valid(int[] mx, int mid, int k, int m){
        for(int i=0; i<mx.length && m>0;){
            if(mx[i] <= mid){
                --m;
                i+=k;
            }
            else
                ++i;
        }
        return m<=0;
    }
}