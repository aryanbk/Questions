class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack();
        for(int i=0, l=s.length(); i<l; i++){
            char q=s.charAt(i);
            if(q=='(') stk.add(')');
            else if(q=='{') stk.add('}');
            else if(q=='[') stk.add(']');
            else{
                if(stk.isEmpty()) return false;
                char w=stk.pop();
                if(q!=w) return false;
            }
        }
        return stk.isEmpty();
    }
}

// won't work
//
// class Solution {
//     public boolean isValid(String s) {
//         int round = 0;
//         int box = 0;
//         int curly = 0;
//         for(int i=0; i<s.length(); ++i){
//             char ch = s.charAt(i);
//             if(ch=='(') ++round;
//             else if(ch==')') --round;
//             else if(ch=='[') ++box;
//             else if(ch==']') --box;
//             else if(ch=='{') ++curly;
//             else --curly;
            
//             if(round<0 || box<0 || curly<0) return false;
//         }
        
//         return round==0 && box==0 && curly==0;
//     }
// }