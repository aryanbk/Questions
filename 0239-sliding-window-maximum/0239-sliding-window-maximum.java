class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        
        for(int l=0, r=0; r<nums.length; ++r){
            while(dq.size()>0 && dq.getLast() < nums[r])
                dq.removeLast();
            dq.addLast(nums[r]);
            
            if(r-l+1 == k){
                int subMax = dq.getFirst();
                ans[l] = subMax;
                if(nums[l] == subMax)
                    dq.removeFirst();
                ++l;
            }
        }
        return ans;
    }
}