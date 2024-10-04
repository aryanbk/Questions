class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int sumt = skill[0]+skill[n-1];
        long ans = 0;
        for(int i=0; i<n/2; ++i){
            if(skill[i]+skill[n-i-1] != sumt) return -1;
            else ans += (long)skill[i] * (long)skill[n-i-1];
        }
        return ans;
    }
}