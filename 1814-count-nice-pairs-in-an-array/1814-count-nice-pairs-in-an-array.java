class Solution {
    public int countNicePairs(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        long ans = 0;
        int MOD = 1000000007;
        for(int i=0; i<nums.length; ++i){
            long num = nums[i];
            long revnum = rev(nums[i]);
            long rhs = nums[i] - revnum;
            ans = (ans + map.getOrDefault(rhs, 0))%MOD;
            map.put(rhs, map.getOrDefault(rhs, 0) + 1);
            // System.out.println(num+" "+revnum+" "+rhs);
        }
        // for(long k: map.keySet()){
            // System.out.println(k+" "+map.get(k));
        // }
        return (int)ans;
    }
    private long rev(int i){
        long ans = 0;
        while(i != 0){
            ans *= 10;
            ans += i%10;
            i /= 10;
        }
        return ans;
    }
}