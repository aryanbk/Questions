class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> mn = new ArrayDeque<>();
        Deque<Integer> mx = new ArrayDeque<>();
        int ans = 0;
        
        
        for(int l=0, r=0; r<nums.length; ++r){
            while(!mn.isEmpty() && mn.getLast()>nums[r])
                mn.removeLast();
            while(!mx.isEmpty() && mx.getLast()<nums[r])
                mx.removeLast();
            mn.addLast(nums[r]);
            mx.addLast(nums[r]);
            
            
            while(!mn.isEmpty() && !mx.isEmpty() && mx.getFirst()-mn.getFirst()>limit){
                if(mn.getFirst()==nums[l])
                    mn.removeFirst();
                if(mx.getFirst()==nums[l])
                    mx.removeFirst();
                ++l;
            }
            
            ans = Math.max(ans, r-l+1);
        }
        return ans;

    }
}