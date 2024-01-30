class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stk = new Stack<>();
        for(var t: tokens){
            if(t.equals("+")){
                int sec = Integer.parseInt(stk.pop());
                int first = Integer.parseInt(stk.pop());
                stk.push(Integer.toString(first+sec));
            }
            else if(t.equals("-")){
                int sec = Integer.parseInt(stk.pop());
                int first = Integer.parseInt(stk.pop());
                stk.push(Integer.toString(first-sec));
            }
            else if(t.equals("*")){
                int sec = Integer.parseInt(stk.pop());
                int first = Integer.parseInt(stk.pop());
                stk.push(Integer.toString(first*sec)); 
            }
            else if(t.equals("/")){
                int sec = Integer.parseInt(stk.pop());
                int first = Integer.parseInt(stk.pop());
                stk.push(Integer.toString(first/sec));                
            }
            else{
                stk.push(t);
            }
        }
        return Integer.parseInt(stk.pop());
    }
}