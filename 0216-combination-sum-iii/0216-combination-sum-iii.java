class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        bkt(1, k, n, new ArrayList<>());
        return ans;
    }
    
    void bkt(int i, int k, int n, List<Integer> sub){
        if(n==0 && k==0){
            ans.add(new ArrayList<>(sub));
            return;
        }
        if(i==10 || k==0 || i>n) return;
        
        bkt(i+1, k, n, sub);
        sub.add(i);
        bkt(i+1, k-1, n-i, sub);
        sub.remove(sub.size() - 1);
        return;
    }
}