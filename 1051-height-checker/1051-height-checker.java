class Solution {
    public int heightChecker(int[] heights) {
        int[] freq = new int[101];
        for(int h: heights) ++freq[h];
        
        int cur = 0;
        int ans = 0;
        for(int i=0; i<101; ++i){
            while(freq[i] > 0){
                if(heights[cur] != i) ++ans;
                ++cur;
                --freq[i];
            }
        }
        
        return ans;
    }
}



// class Solution {
//     public int heightChecker(int[] heights) {
//         int[] sorted = heights.clone();
//         Arrays.sort(sorted);
//         return (int) IntStream.range(0, heights.length)
//             .filter(i -> sorted[i] != heights[i])
//             .count();
//     }
// }
