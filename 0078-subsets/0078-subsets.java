class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans=new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>());
        return ans;
    }
    void helper(int[] nums, int i, List<Integer> list){
        if(i>=nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        helper(nums, i+1, list);
        list.remove(list.size()-1);
        helper(nums, i+1, list);
    }
}