class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        long sumt=0;
        int l=gas.length;
        for(int i=0; i<l; ++i){
            gas[i]-=cost[i];
            sumt+=gas[i];
        }
        if(sumt<0) return -1;
        int start=0, i=0, tank=0;
        while(true){
            if(start == i-l) return i%l;
            tank += gas[i%l];
            i++;
            if(tank<0){
                tank=0;
                start=i;
            }
        }
    }
}