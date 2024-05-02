class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = -1;
        for(int i: nums){
            if(set.contains(-1*i)) ans = Math.max(ans, Math.abs(i));
            set.add(i);
        }
        return ans;
    }
}