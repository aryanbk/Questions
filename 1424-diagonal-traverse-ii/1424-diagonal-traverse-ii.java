// O(m*n)

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        int n = nums.size(), total = 0, mxSumt = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<n; ++i){
            for(int j=0; j<nums.get(i).size(); ++j){
                if (!map.containsKey(i + j))
                    map.put(i + j, new ArrayList<>());
                map.get(i + j).add(nums.get(i).get(j));
                total++;
                mxSumt = Math.max(mxSumt, i+j);
            }
        }
        
        int[] ans = new int[total];
        int ptr = 0;
        
        for(int sumt=0; sumt<=mxSumt; ++sumt){
            List<Integer> a = map.get(sumt);
            for(int i=a.size()-1; i>=0; --i)
                ans[ptr++] = a.get(i);
        }
        return ans;
    }
}


// gives TLE
// O(m*m*n)
//
// class Solution {
//     public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
//         int n = nums.size();
//         int mxSumt = 0;
//         int elements = 0;
        
//         for(int i=0; i<n; ++i){
//             // elements += nums.get(i).size();
//             for(int j=0; j<nums.get(i).size(); ++j){
//                 mxSumt = Math.max(mxSumt, i+j);
//                 ++elements;
//             }
//         }
        
//         int[] ans = new int[elements];
//         int ptr = 0;
        
//         System.out.println(mxSumt+" "+elements);

//         for(int sumt=0; sumt <= mxSumt; ++sumt){
//             // int i = Math.min(sumt, n-1);
//             // while(i>=0 && sumt-i<nums.get(i).size()){
//             //     ans[ptr] = nums.get(i).get(sumt - i);
//             //     ptr++;
//             //     --i;
//             // }
            
//             for(int i = Math.min(sumt, n-1); i>=0; --i){
//                 int j = sumt - i;
//                 if(j<nums.get(i).size()){
//                     ans[ptr] = nums.get(i).get(j);
//                     ptr++;
//                 }
//             }
//         }
        
//         // for(int sumt=0; sumt <= mxSumt; ++sumt){
//         //     for(int i = Math.min(sumt, n-1); i>=0; --i){
//         //         int j = sumt - i;
//         //         if(j<nums.get(i).size()){
//         //             ans[ptr] = nums.get(i).get(j);
//         //             ptr++;
//         //         }
//         //     }
//         // }
        
//         return ans;
//     }
// }