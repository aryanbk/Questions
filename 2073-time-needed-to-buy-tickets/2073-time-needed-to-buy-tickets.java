class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        for(int i=0; i<tickets.length; ++i)
            ans += i<=k ? Math.min(tickets[i], tickets[k])
                : Math.min(tickets[i], tickets[k]-1);
        
        return ans;
    }
}



// class Solution {
//     public int timeRequiredToBuy(int[] tickets, int k) {
//         int ans = 0;
//         while(tickets[k] != 0){
//             for(int i=0; i<tickets.length && tickets[k]!=0; ++i){
//                 if (tickets[i] > 0){
//                     --tickets[i];
//                     ++ans;
//                 }
//             }
//         }
//         return ans;
//     }
// }