class Solution {
    public String longestWord(String[] words) {
        Trie root = new Trie();
        root.end = true;
        
        for(String w: words){
            Trie cur = root;
            for(int i=0; i<w.length(); ++i){
                if(cur.map[w.charAt(i)-'a'] == null)
                    cur.map[w.charAt(i)-'a'] = new Trie();
                cur = cur.map[w.charAt(i)-'a'];
            }
            cur.end = true;
        }
        
        // return String.join("", dfs(root));
        StringBuilder ans = new StringBuilder();
        var res = dfs(root);
        // System.out.println(res);
        for(var c: res)
            ans.append(c);
        return ans.toString();
    }
    
    List<Character> dfs(Trie root){
        if(!root.end)
            return new ArrayList<>();
        List<Character> ans = new ArrayList<>();
        int mxSize = 0;
        for(int i=0; i<26; ++i){
            if(root.map[i] != null && root.map[i].end){
                List<Character> res = dfs(root.map[i]);
                if(res.size() + 1 > mxSize){
                    mxSize = res.size() + 1;
                    ans = new ArrayList<>();
                    ans.add((char)(i+'a'));
                    ans.addAll(res);
                }
            }
        }
        // System.out.println(ans);
        return ans;
    }
}


class Trie{
    Trie[] map;
    boolean end;
    public Trie(){
        map = new Trie[26];
    }
}