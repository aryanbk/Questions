class Solution {
    List<Integer> ans;
    int n;
    public List<Integer> lexicalOrder(int n) {
        ans = new ArrayList<>();
        this.n = n;
        
        for(int i=1; i<10; ++i) solve(i);
        return ans;
    }
    
    void solve(int i){
        if(i>n) return;
        ans.add(i);
        for(int x=0; x<10; ++x) solve((i*10) + x);
    }
}