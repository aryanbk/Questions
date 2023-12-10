class Solution {
    public List<Integer> getGoodIndices(int[][] var, int target) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<var.length; ++i){
            int[] x = var[i];
            int y = pow(x[0], x[1], 10);
            if(pow(y, x[2], x[3]) == target)
                ans.add(i);
        }
        return ans;
    }
    
    private int pow(int i, int j, int m){
        long ans = 1;
        while(j > 0){
            ans = (ans * i) % m;
            j--;
        }
        return (int)ans;
    }
    
    
}


// class Solution {
//     public List<Integer> getGoodIndices(int[][] var, int target) {
//         List<Integer> ans = new ArrayList<>();
//         for(int i=0; i<var.length; ++i){
//             int[] x = var[i];
//             int y = pow(x[0], x[1], 10);
//             if(pow(y, x[2], x[3]) == target)
//                 ans.add(i);
//         }
//         return ans;
//     }
    
//     private int pow(int i, int j, int m){
//         long ans = 1;
//         while(j > 0){
//             if((j&1)==0) ans = (ans * j) % m;
//             else ans = ((ans * j)%m * j) % m;
//             j/=2;
//         }
//         return (int)ans;
//     }
    
    
// }