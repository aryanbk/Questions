class Solution {
    public int findTheWinner(int n, int k) {
        boolean[] map = new boolean[n];
        int cur = 0;
        int x = k;
        int baki = n;
        while(baki!=0){
            if(!map[cur%n]){
                --x;
                if(x==0){
                    map[cur%n] = true;
                    x = k;
                    --baki;
                }
            }
            ++cur;
            // System.out.println(Arrays.toString(map));
        }
        return (cur-1)%n + 1;
    }
}