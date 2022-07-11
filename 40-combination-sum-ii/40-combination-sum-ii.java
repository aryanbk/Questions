class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans= new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>());
        return ans;
    }
    void dfs(int[] candidates, int i, int target, List<Integer> list){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0 || i>=candidates.length) return;
        list.add(candidates[i]);
        dfs(candidates, i+1, target-candidates[i], list);
        list.remove(list.size()-1);
        int j=i;
        while(j<candidates.length && candidates[j]==candidates[i]) j++;
        dfs(candidates, j, target, list);
    }
}