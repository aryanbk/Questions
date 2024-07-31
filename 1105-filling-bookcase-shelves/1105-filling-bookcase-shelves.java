class Solution {
    HashMap<List<Integer>, Integer> dp;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        dp = new HashMap<>();
        return solve(0, 0, 0, books, shelfWidth);
    }
    
    int solve(int i, int curWidth, int curMxHeight, int[][] books, int shelfWidth){
        if(i==books.length) return curMxHeight;
        
        var key = List.of(i, curWidth, curMxHeight);
        if(dp.containsKey(key)) return dp.get(key);
        
        int ans = solve(i+1, books[i][0], books[i][1], books, shelfWidth)+curMxHeight;
        
        if(curWidth + books[i][0] <= shelfWidth){
            int newCurWidth = curWidth + books[i][0];
            int newCurMxHeight = Math.max(curMxHeight, books[i][1]);
            ans = Math.min(ans, solve(i+1, newCurWidth, newCurMxHeight, books, shelfWidth));
        }
        
        dp.put(key, ans);
        return ans;
    }
}


// // understood problem statement wrong - "Note" part
//
// class Solution {
//     HashMap<Key, Integer> dp;
//     public int minHeightShelves(int[][] books, int shelfWidth) {
//         int mxHeight = 0;
//         for(int[] b: books) mxHeight = Math.max(mxHeight, b[1]);
//         int[] pos = new int[mxHeight + 1];
//         dp = new HashMap<>();
//         return solve(0, books, shelfWidth, pos);
//     }
    
//     int solve(int i, int[][] books, int width, int[] pos){
//         if(i==books.length)
//             return findHeight(pos, width);
        
//         Key key = new Key(i, pos);
//         if(dp.containsKey(key)) return dp.get(key);
        
//         int ans = 1000000000;
//         for(int x=books[i][1]; x<pos.length; ++x){
//             pos[x] += books[i][0];
//             ans = Math.min(ans, solve(i+1, books, width, pos));
//             pos[x] -= books[i][0];
//         }
        
//         dp.put(key, ans);
//         return ans;
//     }
    
//     int findHeight(int[] pos, int width){
//         int ans = 0;
//         for(int i=0; i<pos.length; ++i){
//             if(pos[i]!=0){
//                 ans += (((pos[i]-1)/width)+1)*i;
//             }
//         }
//         return ans;
//     }
// }

// public class Key {
//     int i;
//     int[] a;

//     public Key(int i, int[] a) {
//         this.i = i;
//         this.a = a.clone();
//     }

//     @Override
//     public boolean equals(Object o) {
//         if (this == o) return true;
//         if (o == null || getClass() != o.getClass()) return false;
//         Key that = (Key) o;
//         return i == that.i && Arrays.equals(a, that.a);
//     }

//     @Override
//     public int hashCode() {
//         int result = Objects.hash(i);
//         result = 31 * result + Arrays.hashCode(a);
//         return result;
//     }
// }




// class Solution {
//     public int minHeightShelves(int[][] books, int shelfWidth) {
//         Arrays.sort(books, (a, b) -> a[1]==b[1] ? a[0]-b[0] : a[1] - b[1]);
        
//         int baseHeight = 0;
//         int curHeight = 0;
//         int curWidth = 0;
        
//         for(int i=0; i<books.length; ++i){
//             if(curWidth + books[i][0] > shelfWidth){
//                 curWidth = 0;
// 				baseHeight = curHeight;
//             }
// 			curWidth += books[i][0];
// 			curHeight = Math.max(baseHeight+books[i][1], curHeight);
//         }
		
// 		return curHeight;
//     }
// }