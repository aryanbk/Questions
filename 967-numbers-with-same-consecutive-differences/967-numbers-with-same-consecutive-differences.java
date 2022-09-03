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
        int lastd=num%10;
        for(int i=0; i<10; i++){
            if(Math.abs(lastd-i)==k){
                num = (num*10) + i;
                dfs(num, n-1);
                num/=10;
            }
        }
        return;
    }
    
    int[] makeArray(){
        int[] ans=new int[list.size()];
        for(int i=0; i<list.size(); i++)
            ans[i]=list.get(i);
        return ans;
    }
    
}