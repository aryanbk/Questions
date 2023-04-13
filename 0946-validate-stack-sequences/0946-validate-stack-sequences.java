class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk=new Stack<>();
        for(int i=0,j=0,l=pushed.length; i<l && j<l; i++){
            stk.push(pushed[i]);
            while(!stk.isEmpty() && stk.peek()==popped[j]){
                stk.pop();
                j++;
            }
        }
        //
        return stk.isEmpty();
        
    }
}