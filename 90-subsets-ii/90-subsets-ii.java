class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans=new ArrayList<>();
        Arrays.sort(nums);
        dfsSubset(nums, 0, new ArrayList<>());
        return ans;
    }
    void dfsSubset(int[] nums, int i, List<Integer> list){
        if(i==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        dfsSubset(nums, i+1, list);
        list.remove(list.size()-1);
        int j=i;
        while(j<nums.length && nums[j]==nums[i]) j++;
        dfsSubset(nums, j, list);
    }
}
