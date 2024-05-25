class Solution {
    List<String> ans;
    Node head;
    public List<String> wordBreak(String s, List<String> wordDict) {
        head = new Node();
        head.insert(wordDict);
        
        ans = new ArrayList<>();
        solve(0, s, head, new StringBuilder());
        return ans;
    }
    
    void solve(int i, String s, Node cur, StringBuilder sb){
        if(i == s.length()){
            if(cur.isEnd)
                ans.add(sb.toString());
            return;
        }
        
        char ch = s.charAt(i);
        int idx = ch - 'a';
        Node nx = cur.child[idx];
        
        if(nx == null) return;
        sb.append(ch);
        
        if(nx.isEnd && i != s.length()-1){
            sb.append(' ');
            solve(i+1, s, head, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        solve(i+1, s, nx, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}

class Node {
    Node[] child;
    boolean isEnd;
    
    public Node(){
        child = new Node[26];
        isEnd = false;
    }
    
    void insert(List<String> words){
        for(String word: words){            
            Node cur = this;
            for(int i=0; i<word.length(); ++i){
                int idx = word.charAt(i)-'a';
                if(cur.child[idx] == null)
                    cur.child[idx] = new Node();
                cur = cur.child[idx];
            }
            cur.isEnd = true;
        }
    }
}








// class Solution {
//     List<String> ans;
//     Node head;
//     public List<String> wordBreak(String s, List<String> wordDict) {
//         head = new Node();
//         head.insert(wordDict);
        
//         ans = new ArrayList<>();
//         solve(0, s, head, new StringBuilder());
//         return ans;
//     }
    
//     void solve(int i, String s, Node cur, StringBuilder sb){
//         if(i == s.length()){
//             ans.add(sb.toString());
//             return;
//         }
        
//         char ch = s.charAt(i);
//         int idx = ch - 'a';
//         Node nx = cur.child[idx];
        
//         if(nx == null) return;
//         sb.append(ch);
        
//         if(nx.isEnd == true && i != s.length()-1){
//             StringBuilder sb2 = new StringBuilder(sb);
//             sb2.append(' ');
//             solve(i+1, s, head, sb2);
//             // sb.deleteCharAt(sb.length() - 1);
//         }
        
//         solve(i+1, s, nx, sb);
//     }
// }

// class Node {
//     Node[] child;
//     boolean isEnd;
    
//     public Node(){
//         child = new Node[26];
//         isEnd = false;
//     }
    
//     void insert(List<String> words){
//         for(String word: words){            
//             Node cur = this;
//             for(int i=0; i<word.length(); ++i){
//                 int idx = word.charAt(i)-'a';
//                 if(cur.child[idx] == null)
//                     cur.child[idx] = new Node();
//                 cur = cur.child[idx];
//             }
//             cur.isEnd = true;
//         }
//     }
// }