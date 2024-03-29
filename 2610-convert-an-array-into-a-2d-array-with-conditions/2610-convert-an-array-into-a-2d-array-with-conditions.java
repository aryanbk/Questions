class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n+1];
        var ans = new ArrayList<List<Integer>>();
        
        for(var num: nums){
            
            if(freq[num] >= ans.size()) ans.add(new ArrayList<>());
            
            ans.get(freq[num]).add(num);
            freq[num]++;
        }
        
        return ans;
    }
}




// class Solution {
//     public List<List<Integer>> findMatrix(int[] nums) {
//         int n = nums.length;
//         int[] freq = new int[n+1];
        
//         for(var num: nums)
//             freq[num]++;
        
//         var ans = new ArrayList<List<Integer>>();
        
//         for(int i=0; i<=n; ++i){
//             for(int j=0; j<freq[i]; ++j){
//                 if(ans.size() > j)
//                     ans.get(j).add(i);
//                 else{
//                     var sub = new ArrayList<Integer>();
//                     sub.add(i);
//                     ans.add(sub);  
//                 }
//             }
//         }
        
//         return ans;
//     }
// }


// class Solution {
//     public List<List<Integer>> findMatrix(int[] nums) {
//         var freq = new int[201];
        
//         for(var n: nums) freq[n]++;
        
//         var ans = new ArrayList<List<Integer>>();
        
//         while(true){
//             var sub = new ArrayList<Integer>();
//             for(int i=0; i<201; ++i){
//                 if(freq[i]-- > 0) sub.add(i);
//             }    
            
//             if(sub.size()==0) break;
//             ans.add(sub);
//         }
        
//         return ans;
//     }
// }




// class Solution {
//     public List<List<Integer>> findMatrix(int[] nums) {
//         int[] freq = new int[201];
        
//         for(var n: nums)
//             freq[n]++;
        
//         var ans = new ArrayList<List<Integer>>();
//         while(true){
//             var sub = new ArrayList<Integer>();
//             for(int i=0; i<201; ++i){
//                 if(freq[i] > 0){
//                     sub.add(i);
//                     freq[i]--;
//                 }
//             }    
            
//             if(sub.size()==0) break;
//             ans.add(sub);
//         }
        
//         return ans;
//     }
// }