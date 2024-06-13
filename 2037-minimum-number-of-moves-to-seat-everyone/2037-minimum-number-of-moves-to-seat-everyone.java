class Solution {
    public int minMovesToSeat(int[] seats, int[] std) {
        Arrays.sort(seats);
        Arrays.sort(std);
        int ans = 0;
        for(int i=0; i<seats.length; ++i)
            ans += Math.abs(seats[i]-std[i]);
        
        return ans;
    }
}