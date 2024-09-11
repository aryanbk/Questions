class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = 0;
        for(; start!=0 || goal!=0; start/=2, goal/=2) ans += (start%2) ^ (goal%2);
        return ans;
    }
}