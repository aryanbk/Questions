class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        Trie root = new Trie();
        int ans = 0;
        
        for(int i=0; i<n; ++i){
            
            int div = 0;
            Trie tempRoot = root;
            
            for(int j=i; j<n; ++j){
                if(nums[j] % p == 0) ++div;
                if(div > k) break;
                
                if(!tempRoot.map.containsKey(nums[j])){
                    tempRoot.map.put(nums[j], new Trie());
                    ++ans;
                }
                tempRoot = tempRoot.map.get(nums[j]);
                
            }
        }
        
        return ans;
    }
}


class Trie {
    Map<Integer, Trie> map;    
    public Trie() {
        map = new HashMap<>();
    }
}





// class Solution {
//     public int countDistinct(int[] nums, int k, int p) {
//         int n = nums.length;
//         int div = 0;
        
//         Set<List<Integer>> set = new HashSet<>();
//         List<Integer> list = new ArrayList<>();
//         for(int x: nums) list.add(x);
        
//         for(int l=0, r=0; r<n; ++r){
//             div += list.get(r)%p == 0 ? 1 : 0;
            
//             while(l<n && div > k){
//                 div -= list.get(l)%p == 0 ? 1 : 0;
//                 l++;
//             }
            
//             for(int x=0; x<r-l+1; ++x)
//                 set.add(list.subList(x+l, r+1));
            
//         }
        
//         return set.size();
//     }
// }


// // wont give correct answer
//
// class Solution {
//     public int countDistinct(int[] nums, int k, int p) {
//         int n = nums.length;
//         int l = 0;
//         int div = 0;
//         int ans = 0;
        
//         for(int r=0; r<n; ++r){
//             div += nums[r]%p == 0 ? 1 : 0;
            
//             while(l<n && div > k){
//                 div -= nums[l]%p == 0 ? 1 : 0;
//                 l++;
//             }
//             ans += r - l + 1;
//         }
        
//         return ans;
        
        
//     }
// }