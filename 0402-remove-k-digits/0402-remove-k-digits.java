class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<num.length(); ++i){
            char ch = num.charAt(i);
            while(sb.length()>0 && ch < sb.charAt(sb.length()-1) && k>0){
                sb.deleteCharAt(sb.length()-1);
                --k;
            }
            if(sb.length()==0 && ch=='0') continue;
            sb.append(ch);
        }
        while(sb.length()>0 && k-->0) sb.deleteCharAt(sb.length()-1);
        return sb.length()==0 ? "0" : sb.toString();
    }
}


// // didn't work
//
// class Solution {
//     public String removeKdigits(String num, int k) {
//         Stack<Character> stk = new Stack<>();
//         for(int i=0; i<num.length(); ++i){
//             char ch = num.charAt(i);
//             if(!stk.isEmpty() && ch < stk.peek() && k>0){ // it should be while(){}
//                 stk.pop();
//                 --k;
//             }
//             stk.push(ch);
//         }
//         // System.out.println(stk+" "+k);
//         // return "0";
//         StringBuilder sb = new StringBuilder();
//         while(stk.size() != k) sb.append(stk.pop());
//         while(sb.length()>0 && sb.charAt(sb.length() - 1) == '0')
//             sb.deleteCharAt(sb.length() - 1);
//         sb.reverse();
//         return sb.length()!=0 ? sb.toString() : "0";
//     }
// }



// class Solution {
//     Map<String, String> dp = new HashMap<>();
//     public String removeKdigits(String num, int k) {
//         return solve(num, k);
//     }
//     String solve(String num, int k){
//         if(k==0) return num;
//         if(dp.containsKey(num)) return dp.get(num);
        
//     }
// }


// class Solution {
//     HashMap<String, String> dp=new HashMap<>();
//     public String removeKdigits(String num, int k) {
//         if(k==0) return num;
//         if(dp.containsKey(num)) return dp.get(num);
//         else{
//             String ans=removeKdigits(num.substring(1), k-1);
//             for(int i=1; i<num.length(); i++){
//                 String ans2=removeKdigits(num.substring(0,i)+num.substring(i+1), k-1);
//                 if(ans.compareTo(ans2)>0) ans=ans2;
//             }
//             int x=0;
//             while(x<ans.length() && ans.charAt(x)=='0') x++;
//             ans=ans.substring(x);
//             if(ans.length()==0) ans="0";
//             dp.put(num, ans);
//             return ans;
//         }
//     }
// }