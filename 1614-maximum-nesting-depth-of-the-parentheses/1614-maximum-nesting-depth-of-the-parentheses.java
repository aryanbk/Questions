class Solution {
    public int maxDepth(String s) {
        Stack<Character> stk = new Stack<>();
        int ans = 0;
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i)=='(')
                stk.push('(');
            if(s.charAt(i)==')')
                stk.pop();
            ans = Math.max(ans, stk.size());
        }
        return ans;
    }
}