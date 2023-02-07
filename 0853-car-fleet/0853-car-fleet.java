class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
        int l = speed.length;
        int[][] cmb = new int[l][2]; // combine
        for(int i=0; i<l; ++i){
            cmb[i][0] = pos[i];
            cmb[i][1] = speed[i];
        }
        Arrays.sort(cmb, java.util.Comparator.comparingInt(x -> x[0]));
        Stack<Double> stk = new Stack<>();
        
        for(int i=l-1; i>=0; --i){
            double time = (double)(target - cmb[i][0]) / (double)(cmb[i][1]);
            if(stk.size()==0 || time>stk.peek())
                stk.push(time);
        }
        
        return stk.size();
    }
}