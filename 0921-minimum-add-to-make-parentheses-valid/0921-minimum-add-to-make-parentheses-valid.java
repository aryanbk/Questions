class Solution {
    public int minAddToMakeValid(String s) {
        int stk = 0;
        int ans = 0;
        for(int i=0; i<s.length(); ++i){
            if(stk==0 && s.charAt(i)==')') ++ans;
            else if(stk>0 && s.charAt(i)==')') --stk;
            else ++stk;
        }
        return stk+ans;
    }
}




// class Solution {
//     public int minAddToMakeValid(String s) {
//         Stack<Character> stk = new Stack<>();
//         for(int i=0; i<s.length(); ++i){
//             if(!stk.isEmpty() && stk.peek()=='(' && s.charAt(i)==')')
//                 stk.pop();
//             else
//                 stk.push(s.charAt(i));
//         }
//         return stk.size();
//     }
// }