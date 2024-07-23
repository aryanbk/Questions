class Solution {
    public int[] frequencySort(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        Integer[] nums2 = new Integer[nums.length];
        for(int i=0; i<nums.length; ++i){
            int n = nums[i];
            map.put(n, map.getOrDefault(n, 0)+1);
            nums2[i] = n;
        }
        Arrays.sort(nums2, (a, b)-> map.get(a)==map.get(b) ? b-a : map.get(a)-map.get(b));
        for(int i=0; i<nums.length; ++i) nums[i] = nums2[i];
        return nums;
    }
}