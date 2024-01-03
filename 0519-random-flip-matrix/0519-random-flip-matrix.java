class Solution {
    int m;
    int n;
    int tot;
    Random rndm;
    Map<Integer, Integer> map;
    
    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        tot = m*n;
        
        rndm = new Random();
        map = new HashMap<>();
    }
    
    public int[] flip() {
        int num = rndm.nextInt(tot--);
        int num2 = map.getOrDefault(num, num);
        map.put(num, map.getOrDefault(tot, tot));
        
        return new int[]{num2/n, num2%n};
    }
    
    public void reset() {
        map.clear();
        tot = m*n;
    }
}


// // memory limit exceeded
//
// class Solution {
//     int m;
//     int n;
//     int tot;
//     Random rndm;
//     int[] map;
    
//     public Solution(int m, int n) {
//         this.m = m;
//         this.n = n;
//         tot = m*n;
        
//         rndm = new Random();
//         map = new int[m*n];
//         Arrays.setAll(map, a->a);
//     }
    
//     public int[] flip() {
//         int num = rndm.nextInt(tot);
//         int num2 = map[num];
//         map[num] = map[--tot];
        
//         return new int[]{num2/n, num2%n};
//     }
    
//     public void reset() {
//         // map.clear();
//         Arrays.setAll(map, a->a);
//         tot = m*n;
//     }
// }




// // memory limit exceeded
//
// class Solution {
//     int[][] mat;
//     int m;
//     int n;
//     int tot;
//     Random rndm;
//     public Solution(int m, int n) {
//         this.m = m;
//         this.n = n;
//         tot = m*n;
//         mat = new int[m][n];
//         rndm = new Random();
//     }
    
//     public int[] flip() {
//         int num = rndm.nextInt(tot);
//         int x = num/n;
//         int y = num%n;
//         if(mat[x][y] == 1)
//             return flip();
//         mat[x][y] = 1;
//         return new int[]{x, y};
//     }
    
//     public void reset() {
//         mat = new int[m][n];
//     }
// }



// class Solution {
//     int[][] mat;
//     int m;
//     int n;
//     Random rndm;
//     public Solution(int m, int n) {
//         this.m = m;
//         this.n = n;
//         mat = new int[m][n];
//         rndm = new Random();
//     }
    
//     public int[] flip() {
//         int x = rndm.nextInt(m);
//         int y = rndm.nextInt(n);
//         if(mat[x][y] == 1)
//             return flip();
//         mat[x][y] = 1;
//         return new int[]{x, y};
//     }
    
//     public void reset() {
//         mat = new int[m][n];
//     }
// }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */