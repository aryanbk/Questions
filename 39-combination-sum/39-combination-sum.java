class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans=new ArrayList<>();
        combRec(candidates, 0, target, new ArrayList<>());
        return ans;
    }
    void combRec(int[] candidates, int ptr, int target, List<Integer> list){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0 || ptr>=candidates.length) return;
        list.add(candidates[ptr]);
        combRec(candidates, ptr, target-candidates[ptr], list);
        list.remove(list.size()-1);
        combRec(candidates, ptr+1, target, list);
    }
}