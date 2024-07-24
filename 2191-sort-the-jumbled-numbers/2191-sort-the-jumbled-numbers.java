class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[] nums2 = new Integer[nums.length];
        for(int i=0; i<nums.length; ++i)
            nums2[i] = nums[i];
        var map = new HashMap<Integer, Integer>();
        for(int n: nums) map.putIfAbsent(n, val(n, mapping));
        Arrays.sort(nums2, (a, b) -> map.get(a)-map.get(b));
        for(int i=0; i<nums.length; ++i) nums[i] = nums2[i];
        return nums;
        
    }
    
    int val(int n, int[] mapping){
        String num = Integer.toString(n);
        int ans = 0;
        for(int i=0; i<num.length(); ++i){
            int cur = num.charAt(i)-'0';
            ans = (ans*10)+mapping[cur];
        }
        return ans;
    }
}