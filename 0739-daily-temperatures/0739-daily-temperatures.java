class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        Stack<int[]> stk = new Stack<>();
        int[] ans = new int[n];
        for(int i=n-1; i>=0; --i){
            while(!stk.isEmpty() && stk.peek()[0] <= temp[i]) stk.pop();
            
            if(stk.isEmpty()) ans[i] = 0;
            else ans[i] = stk.peek()[1] - i;
            
            stk.push(new int[]{temp[i], i});
        }
        
        return ans;
    }
}