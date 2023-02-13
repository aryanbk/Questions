class Trie{
    Trie[] child;
    String end;
    public Trie(){
        child = new Trie[26];
    }
}

class Solution {
    Trie head = new Trie();
    HashSet<String> ans = new HashSet<>();
    int m , n;
    int[] dirx = new int[]{1, 0, -1, 0};
    int[] diry = new int[]{0, 1, 0, -1};
    public List<String> findWords(char[][] board, String[] words) {
        for(String w: words){
            Trie curr=head;
            for(int i=0; i<w.length(); i++){
                if(curr.child[w.charAt(i)-97]==null)
                    curr.child[w.charAt(i)-97] = new Trie();
                curr = curr.child[w.charAt(i)-97];
            }
            curr.end = w;
        }
        
        m=board.length;
        n = board[0].length;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                dfs(i, j, board, head);
            }
        }
        return new ArrayList<>(ans);
    }
    private void dfs(int row, int col, char[][] board, Trie curr){
        if(curr.end!=null) ans.add(curr.end);
        if(row<0 || row>=m || col<0 || col>=n || board[row][col]=='#' || curr.child[board[row][col]-97]==null) return;
        
        char temp = board[row][col];
        board[row][col] = '#';
        
        for(int i=0; i<4; ++i)
            dfs(row+dirx[i], col+diry[i], board, curr.child[temp-97]);

        board[row][col] = temp;
    }
}
