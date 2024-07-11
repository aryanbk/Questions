class Solution {
    public String reverseParentheses(String s) {
        StringBuilder ans = new StringBuilder(); // using StringBuilder as Stack

        for(int i=0; i<s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == ')'){
                var sb2 = new StringBuilder(); // to store reversed String
                while(ans.length()>0){
                    int l = ans.length();
                    char last = ans.charAt(l-1);
                    ans.deleteCharAt(l-1);
                    if(last == '(') break;
                    else sb2.append(last);
                }
                ans.append(sb2);
            }
            else
                ans.append(s.charAt(i));
        }
        
        return ans.toString();
    }
}