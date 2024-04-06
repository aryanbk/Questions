class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stk = new Stack<>();
        int open = 0;
        int[] close = new int[s.length()+1];
        
        for(int i=s.length()-1; i>=0; --i)
            close[i] = close[i+1] + (s.charAt(i)==')' ? 1 : 0);
        
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i) == ')'){
                if(open>0){
                    stk.push(')');
                    --open;
                }
            }
            else if(s.charAt(i) == '('){
                if(close[i] - open++ > 0) stk.push('(');
            }
            else
                stk.push(s.charAt(i));
        }
        
        char[] ans = new char[stk.size()];
        for(int i=ans.length-1; i>=0; --i) ans[i] = stk.pop();
        
        return new String(ans);
    }
}