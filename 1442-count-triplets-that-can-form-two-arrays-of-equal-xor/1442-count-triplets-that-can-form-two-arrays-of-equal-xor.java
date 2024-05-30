class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int ans = 0;
        
        for(int i=0; i<n; ++i){
            int a = arr[i];
            for(int j=i+1; j<n; ++j){
                int b = 0;
                for(int k=j; k<n; ++k){
                    b ^= arr[k];
                    if(a == b) ++ans;
                }
                a ^= arr[j];
            }
        }
        
        return ans;
    }
}