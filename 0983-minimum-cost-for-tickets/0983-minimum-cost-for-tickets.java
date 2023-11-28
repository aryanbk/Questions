// class Solution {
//     int[][] memo;
    
//     public int mincostTickets(int[] days, int[] costs) {
//         memo = new int[days.length][366];
//         for (int[] m1 : memo) Arrays.fill(m1, -1); // Initialize with -1 instead of Integer.MAX_VALUE
        
//         return help(0, 0, days, costs);
//     }
    
//     private int help(int i, int freeTill, int[] days, int[] costs) {
//         if (i == days.length) return 0;
        
//         if (memo[i][freeTill] != -1) return memo[i][freeTill];
        
//         int result;
//         if (freeTill >= days[i]) {
//             result = help(i + 1, freeTill, days, costs);
//         } else {
//             result = Math.min(
//                 costs[0] + help(i + 1, days[i], days, costs),
//                 Math.min(
//                     costs[1] + help(i + 1, days[i] + 6, days, costs),
//                     costs[2] + help(i + 1, days[i] + 29, days, costs)
//                 )
//             );
//         }
        
//         memo[i][freeTill] = result;
//         return result;
//     }
// }



// class Solution {
//     int[][] memo;
//     public int mincostTickets(int[] days, int[] costs) {
//         memo = new int[days.length][366];
//         for(int[] m1: memo) Arrays.fill(m1, -1);
        
//         return help(0, 0, days, costs);
//     }
//     private int help(int i, int freeTill, int[] days, int[] costs){
//         if(i==days.length) return 0;
        
//         if(memo[i][freeTill] != -1) return memo[i][freeTill];
        
//         int ans = Integer.MAX_VALUE;
//         if(freeTill>=days[i]) ans = Math.min(ans, help(i+1, freeTill, days, costs));
//         else{
//             ans = Math.min(ans, costs[0]+help(i+1, Math.min(i, 365), days, costs));
//             if(i==0) System.out.println(ans);
//             ans = Math.min(ans, costs[1]+help(i+1, Math.min(i+6, 365), days, costs));
//             if(i==0) System.out.println(ans);
//             ans = Math.min(ans, costs[2]+help(i+1, Math.min(i+29, 365), days, costs));
//             if(i==0) System.out.println(ans);

//         }
//         memo[i][freeTill] = ans;
//         return memo[i][freeTill];
//     }
// }



class Solution {
    int[][] memo;
    public int mincostTickets(int[] days, int[] costs) {
        Arrays.sort(days);
        memo = new int[days.length][410];
        for(int[] m1: memo) Arrays.fill(m1, -1);
        
        return help(0, 0, days, costs);
    }
    private int help(int i, int freeTill, int[] days, int[] costs){
        if(i==days.length) return 0;
        
        if(memo[i][freeTill] != -1) return memo[i][freeTill];
        
        memo[i][freeTill] = Integer.MAX_VALUE;
        if(freeTill>=days[i]) memo[i][freeTill] = Math.min(memo[i][freeTill], help(i+1, freeTill, days, costs));
        else{
            memo[i][freeTill] = Math.min(memo[i][freeTill], costs[0]+help(i+1, 0,days, costs));
            memo[i][freeTill] = Math.min(memo[i][freeTill], costs[1]+help(i+1, days[i]+6, days, costs));
            memo[i][freeTill] = Math.min(memo[i][freeTill], costs[2]+help(i+1, days[i]+29, days, costs));
        }
        return memo[i][freeTill];
    }
}