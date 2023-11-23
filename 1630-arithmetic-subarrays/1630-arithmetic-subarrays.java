class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();
        
        for(int i=0; i<m; ++i){
            int[] sub = Arrays.copyOfRange(nums, l[i], r[i]+1);
            Arrays.sort(sub);
            
            int j = 0;
            int diff = sub[1] - sub[0];
            for(; j<r[i]-l[i]; ++j){
                if(sub[j+1] - sub[j] != diff){
                    break;
                }
            }
            ans.add(j==r[i]-l[i]);
        }
        
        return ans;
    }
}