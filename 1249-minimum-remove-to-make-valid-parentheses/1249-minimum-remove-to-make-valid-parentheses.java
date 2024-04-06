class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stk = new Stack<>();
        int open = 0;
        int total = 0;
        int[] close = new int[s.length()+1];
        for(int i=s.length()-1; i>=0; --i)
            close[i] = close[i+1] + (s.charAt(i)==')' ? 1 : 0);
        
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i) == ')'){
                if(open>0){
                    stk.push(')');
                    --open;
                }
                continue;
            }
            else if(s.charAt(i) == '('){
                ++open;
                ++total;
                if(close[i] - open >= 0)
                    stk.push('(');
            }
            else
                stk.push(s.charAt(i));
            // System.out.println(stk+" "+open);
        }
        char[] ans = new char[stk.size()];
        int idx = ans.length-1;
        System.out.println(stk+" "+open+" "+total+" "+idx+" "+stk.size());
        while(idx >= 0){
            char ch = stk.pop();
            ans[idx--] = ch;
            // if(ch == '(' && total > open){
            //     ans[idx--] = ch;
            //     --total;
            // }
            // else{
            //     ans[idx--] = ch;
            // }
        }
        
        return new String(ans);
    }
}