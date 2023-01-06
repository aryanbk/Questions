class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i=0;
        // while(i<costs.length && coins-costs[i]>=0){
        //     coins-=costs[i];
        //     i++;
        // }
        for(; i<costs.length && coins-costs[i]>=0; ++i) coins-=costs[i];
        return i;
    }
}