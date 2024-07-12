class Solution {
    int ans = 0;
    public int maximumGain(String s, int x, int y) {
        var sb = new StringBuilder(s);
        // return x>y ? solve(sb, x, y) : solve(sb.reverse(), x, y);
        // char f = x>y ? 'a' : 'b';
        // char s = x>y ? 'b' : 'a';
        if(x>y){
            sb = solve(sb, x, 'a', 'b');
            solve(sb, y, 'b', 'a');
        }
        else{
            sb = solve(sb, y, 'b', 'a');
            solve(sb, x, 'a', 'b');
        }
        
        return ans;
    }
    
    StringBuilder solve(StringBuilder sb, int val, char f, char s){
        // System.out.println(f+""+s);
        var sb2 = new StringBuilder();
        for(int i=0; i<sb.length(); ++i){
            char cur = sb.charAt(i);
            if(sb2.length()!=0 && cur==s && sb2.charAt(sb2.length()-1)==f){
                ans += val;
                sb2.deleteCharAt(sb2.length()-1);
            }
            else
                sb2.append(cur);
            // System.out.println(sb2+" "+ans);
        }
        return sb2;
    }
}



// // First Attempt
// // WA 1
//
//
// class Solution {
//     public int maximumGain(String s, int x, int y) {
//         Stack<Character> stk = new Stack<>();
//         boolean abMore = x>=y;
//         int ans = 0;
        
//         for(int i=0; i<s.length(); ++i){
//             char c = s.charAt(i);
//             if(c!='a' && c!='b'){
//                 stk.push(c);
//                 continue;
//             }
            
//             else if(c=='b'){
//                 if(!stk.isEmpty() && stk.peek()=='a'){
//                     boolean nextIsA = false;
//                     for(int j=i+1; j<s.length(); ++j){
//                         if(s.charAt(j)!=c){
//                             nextIsA = s.charAt(j)=='a';
//                             break;
//                         }
//                     }
//                     if(x>=y || !nextIsA){
//                         stk.pop();
//                         ans += x;
//                     }
//                     else
//                         stk.push(c);
//                 }
//                 else
//                     stk.push(c);
//             }
            
//             else if(c=='a'){
//                 if(!stk.isEmpty() && stk.peek()=='b'){
//                     // boolean nextIsB = i+1<s.length() && s.charAt(i+1)=='b';
//                     boolean nextIsB = false;
//                     for(int j=i+1; j<s.length(); ++j){
//                         if(s.charAt(j)!=c){
//                             nextIsB = s.charAt(j)=='b';
//                             break;
//                         }
//                     }
//                     if(y>=x || !nextIsB){
//                         stk.pop();
//                         ans += y;
//                     }
//                     else
//                         stk.push(c);
//                 }
//                 else
//                     stk.push(c);
//             }
//             // System.out.println(stk+" "+c+" "+ans);
//         }
        
//         return ans;
//     }
// }