// Java streams
//
class Solution {
    public int minMovesToSeat(int[] seats, int[] std) {
        Arrays.sort(seats);
        Arrays.sort(std);
        return IntStream.range(0, seats.length)
            .map(i -> Math.abs(seats[i]-std[i]))
            .reduce(0, Integer::sum);
    }
}




// // normal method
//
// class Solution {
//     public int minMovesToSeat(int[] seats, int[] std) {
//         Arrays.sort(seats);
//         Arrays.sort(std);
//         int ans = 0;
//         for(int i=0; i<seats.length; ++i)
//             ans += Math.abs(seats[i]-std[i]);
        
//         return ans;
//     }
// }