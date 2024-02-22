class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] map = new int[n+1][2]; //map[out-degree][in-degree]
        for(int[] t: trust){
            map[t[0]][0]++;
            map[t[1]][1]++;
        }
        for(int i=1; i<n+1; ++i){
            if(map[i][0] == 0 && map[i][1]==n-1) return i;
        }
        return -1;
    }
}