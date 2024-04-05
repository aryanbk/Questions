class Solution {
    public String makeGood(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); ++i){
            if(!stk.isEmpty() && Math.abs(stk.peek() - s.charAt(i))==32)
                stk.pop();
            else
                stk.push(s.charAt(i));
        }
        
        char[] ans = new char[stk.size()];
        
        for(int i=0; i<ans.length; ++i)
            ans[ans.length - i - 1] = stk.pop();
        
        return new String(ans);
    }
}