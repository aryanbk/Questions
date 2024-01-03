class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int m = queries.length;
        int n = nums.length;
        int[] ans = new int[m];
        
        for(int i=0; i<m; ++i){
            int k = queries[i][0];
            int trim  = queries[i][1];
            var list = new ArrayList<String[]>();
            
            for(int j=0; j<nums.length; ++j){
                int x = nums[j].length();
                String num = nums[j].substring(Math.max(0, x-trim), x);
                var arr = new String[]{num, Integer.toString(j)};
                list.add(arr);
            }
            Collections.sort(list, (a, b) -> a[0].compareTo(b[0]));
            ans[i] = Integer.parseInt(list.get(k-1)[1]);
        }
        
        return ans;
    }
}


// // WA #1
// //
// class Solution {
//     public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
//         int m = queries.length;
//         int n = nums.length;
//         int[] ans = new int[m];
        
//         for(int i=0; i<m; ++i){
//             int k = queries[i][0];
//             int trim  = queries[i][1];
//             var pq = new PriorityQueue<long[]>(Comparator.comparingLong(a -> -a[0]));
            
//             for(int j=0; j<nums.length; ++j){
//                 int x = nums[j].length();
//                 long trimmedNum = Long.parseLong(nums[j].substring(x-trim, x));
                
//                 pq.offer(new long[]{trimmedNum, j});
//                 if(pq.size() > k)
//                     pq.poll();
//             }
//             ans[i] = (int)pq.peek()[1];
//         }
        
//         return ans;
//     }
// }


// // WA #1
// //
// class Solution {
//     public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
//         int m = queries.length;
//         int n = nums.length;
//         int[] ans = new int[m];
        
//         for(int i=0; i<m; ++i){
//             int k = queries[i][0];
//             int trim  = queries[i][1];
//             var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> -a[0]));
            
//             for(int j=0; j<nums.length; ++j){
//                 int x = nums[j].length();
//                 int trimmedNum = Integer.parseInt(nums[j].substring(x-trim, x));
                
//                 pq.offer(new int[]{trimmedNum, j});
//                 if(pq.size() > k)
//                     pq.poll();
//             }
//             ans[i] = pq.peek()[1];
//         }
        
//         return ans;
//     }
// }