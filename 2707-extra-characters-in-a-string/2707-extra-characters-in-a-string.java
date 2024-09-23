class Solution {
    Trie trie;
    Integer[][] dp;
    public int minExtraChar(String s, String[] dict) {
        trie = new Trie();
        trie.insert(dict);
        dp = new Integer[s.length()+1][s.length()+1];
        return solve(0, s.length(), s)-1;
    }
    
    int solve(int i, int j, String s){
        if(i>j) return 0;
        if(dp[i][j] != null) return dp[i][j];
        
        dp[i][j] = 1000000000;
        for(int x=i+1; x<=j; ++x){
            if(trie.search(i, x, s)) 
                dp[i][j] = Math.min(dp[i][j], solve(x, j, s));
            if(trie.search(x, j, s))
                dp[i][j] = Math.min(dp[i][j], solve(i, x, s));
        }
        
        dp[i][j] = Math.min(dp[i][j], 1+Math.min(solve(i+1, j, s), solve(i, j-1, s)));
        
        return dp[i][j];
    }
}



class Trie{
    Trie[] child;
    boolean isEnd;
    public Trie(){
        child = new Trie[26];
    }
    
    void insert(String[] words){
        for(String w: words){
            Trie cur = this;
            for(int i=0; i<w.length(); ++i){
                int idx = w.charAt(i)-'a';
                if(cur.child[idx] == null) cur.child[idx] = new Trie();
                cur = cur.child[idx];
            }
            cur.isEnd = true;
        }
    }
    
    boolean search(int i, int j, String s){
        Trie cur = this;
        for(; i<j; ++i){
            int idx = s.charAt(i)-'a';
            if(cur.child[idx] == null) return false;
            cur = cur.child[idx];
        }
        return cur.isEnd;
    }
}
