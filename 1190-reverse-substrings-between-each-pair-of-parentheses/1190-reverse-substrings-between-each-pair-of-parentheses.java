class Solution {
    public String reverseParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stk = new Stack<>();

        for(int i=0; i<s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == ')'){
                var sb2 = new StringBuilder();
                while(!stk.isEmpty() && stk.peek() != '(')
                    sb2.append(stk.pop());
                if(!stk.isEmpty()) stk.pop(); // to remove first '('
                for(int j=0; j<sb2.length(); ++j)
                    stk.push(sb2.charAt(j));
            }
            else
                stk.push(s.charAt(i));
        }
        
        while(!stk.isEmpty()) ans.append(stk.pop());
        
        return ans.reverse().toString();
    }
}