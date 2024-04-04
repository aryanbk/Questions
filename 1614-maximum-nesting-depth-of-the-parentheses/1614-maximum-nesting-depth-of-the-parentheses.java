class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int cur = 0;
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i)=='(') ++cur;
            if(s.charAt(i)==')') --cur;
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}


// class Solution {
//     public int maxDepth(String s) {
//         Stack<Character> stk = new Stack<>();
//         int ans = 0;
        // for(int i=0; i<s.length(); ++i){
        //     if(s.charAt(i)=='(')
        //         stk.push('(');
        //     if(s.charAt(i)==')')
        //         stk.pop();
        //     ans = Math.max(ans, stk.size());
        // }
//         return ans;
//     }
// }