class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] t = new int[n];
        for(int[] e : trust){
            t[e[0]-1]--;
            t[e[1]-1]++;
        }
        for(int i=0; i<n; ++i){
            if(t[i]==n-1) return i+1;
        }
        return -1;
    }
}



// class Solution {
//     public int findJudge(int n, int[][] trust) {
//         int[][] map = new int[n+1][2]; //map[out-degree][in-degree]
//         for(int[] t: trust){
//             map[t[0]][0]++;
//             map[t[1]][1]++;
//         }
//         for(int i=1; i<n+1; ++i){
//             if(map[i][0] == 0 && map[i][1]==n-1) return i;
//         }
//         return -1;
//     }
// }