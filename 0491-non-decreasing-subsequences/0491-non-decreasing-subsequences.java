class Solution {
    HashSet<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        find(nums, 0, -101, new ArrayList<Integer>());
        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(res);
        return ans;
    }
    private void find(int[] nums, int ptr, int last, List<Integer> curr){
        if(ptr>=nums.length){
            if(curr.size()>1) res.add(new ArrayList<>(curr));
            return;
        }
        if(nums[ptr]>=last){
            curr.add(nums[ptr]);
            find(nums, ptr+1, nums[ptr], curr);
            curr.remove(curr.size()-1);
        }
        find(nums, ptr+1, last, curr);
        return;
    }
}