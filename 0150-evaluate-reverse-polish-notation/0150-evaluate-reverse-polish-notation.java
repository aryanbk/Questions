class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String c: tokens){
            if(c.equals("+")) stk.push(stk.pop()+stk.pop());
            else if(c.equals("-")) stk.push((stk.pop()*-1)+stk.pop());
            else if(c.equals("*")) stk.push(stk.pop()*stk.pop());
            else if(c.equals("/")){
                int a = stk.pop(), b = stk.pop();
                stk.push(b/a);
            }
            else stk.push(Integer.parseInt(c));
        }
        return stk.peek();
    }
}




// class Solution {
//     public int evalRPN(String[] tokens) {
//         Stack<String> stk = new Stack<>();
//         for(var t: tokens){
//             if(t.equals("+")){
//                 int sec = Integer.parseInt(stk.pop());
//                 int first = Integer.parseInt(stk.pop());
//                 stk.push(Integer.toString(first+sec));
//             }
//             else if(t.equals("-")){
//                 int sec = Integer.parseInt(stk.pop());
//                 int first = Integer.parseInt(stk.pop());
//                 stk.push(Integer.toString(first-sec));
//             }
//             else if(t.equals("*")){
//                 int sec = Integer.parseInt(stk.pop());
//                 int first = Integer.parseInt(stk.pop());
//                 stk.push(Integer.toString(first*sec)); 
//             }
//             else if(t.equals("/")){
//                 int sec = Integer.parseInt(stk.pop());
//                 int first = Integer.parseInt(stk.pop());
//                 stk.push(Integer.toString(first/sec));                
//             }
//             else{
//                 stk.push(t);
//             }
//         }
//         return Integer.parseInt(stk.pop());
//     }
// }