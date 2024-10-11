// class Solution {
//     public int smallestChair(int[][] times, int targetFriend) {
//         int n = times.length;
//         int[][] frd = new int[n][3];
//         for(int i=0; i<n; ++i) frd[i] = new int[]{i, times[i][0], times[i][1]};
//         Arrays.sort(frd, (a, b) -> a[1]-b[1]);
        
//         var pq = new PriorityQueue<
//         for(int i=0; i<n; ++i){
            
//         }
//     }
// }



class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        int n = times.length;
        
        Pair arr[] = new Pair[n];
        Pair dept[] = new Pair[n];
        
        for(int i=0; i<n; i++){
            arr[i] = new Pair(i, times[i][0]);
            dept[i] = new Pair(i, times[i][1]);
        }
        
        Arrays.sort(arr, (a, b) -> a.time - b.time);
        Arrays.sort(dept, (a, b) -> a.time - b.time);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<=10000; i++){
            pq.add(i);
        }
        
        int alloted[] = new int[n];
        
        int i= 0, j = 0;
        
        while(i<n && j<n){
            if(arr[i].time < dept[j].time){
                alloted[arr[i].idx] = pq.poll();
                i++;
            }else if(arr[i].time >= dept[j].time){
                pq.add(alloted[dept[j].idx]);
                j++;
            }
        }
        return alloted[targetFriend];
    }
}
class Pair{
    int idx, time;
    Pair(int idx, int time){
        this.idx = idx;
        this.time = time;
    }
}