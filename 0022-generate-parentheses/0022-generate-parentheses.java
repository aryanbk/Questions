class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        bk(n, n, new StringBuilder());
        return ans;
    }
    
    void bk(int open, int close, StringBuilder sb){
        if(open==0 && close==0){
            ans.add(sb.toString());
            return;
        }
        if(close<open) return;
        if(open>0){
            sb.append('(');
            bk(open-1, close, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close>open){
            sb.append(')');
            bk(open, close-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}