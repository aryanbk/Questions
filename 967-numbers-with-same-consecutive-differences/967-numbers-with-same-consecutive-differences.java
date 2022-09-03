class Solution {
    ArrayList<Integer> list=new ArrayList<>();
    int k;
    public int[] numsSameConsecDiff(int n, int diff) {
        k = diff;
        for(int i=1; i<10; i++){
            dfs(i, n-1);
        }
        return makeArray();
    }
    void dfs(int num, int n){
        if(n==0){
            list.add(num);
            return;
        }
        int l=num%10-k, r=num%10+k;
        if(l>=0) dfs(num*10+l, n-1);
        if(r<=9 && l!=r) dfs(num*10+r, n-1);
        return;
    }
    
    int[] makeArray(){
        int[] ans=new int[list.size()];
        for(int i=0; i<list.size(); i++)
            ans[i]=list.get(i);
        return ans;
    }
    
}