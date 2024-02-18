class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<long[]> queue = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? (int) (a[1] - b[1]) : (int) (a[0] - b[0]));

        int[] roomCount = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++)
            queue.add(new long[] { 0, i });

        for (int[] item : meetings) {
            int time = item[0];

            while (queue.peek()[0] < time) 
                queue.add(new long[] { time, queue.poll()[1] });

            long[] current = queue.poll();
            int curRoom = (int) current[1];
            long meetingEndTime = current[0] + (item[1] - item[0]); 
            roomCount[curRoom]++;

            if (roomCount[curRoom] > roomCount[result]) 
                result = curRoom;
            else if (roomCount[curRoom] == roomCount[result])
                result = Math.min(result, curRoom);

            queue.add(new long[] { meetingEndTime, curRoom });
        }

        return result;
    }
}





// class Solution {
//     public int mostBooked(int n, int[][] meetings) {
//         Arrays.sort(meetings, (a, b) -> a[0]-b[0]);
//         int[] rooms = new int[n];
//         int mx = 0;
//         Comparator<int[]> customComparator = new Comparator<int[]>() {
//             @Override
//             public int compare(int[] arr1, int[] arr2) {
//                 int result = Integer.compare(arr1[1], arr2[1]);
//                 if (result == 0) {
//                     return Integer.compare(arr1[0], arr2[0]);
//                 }
//                 return result;
//             }
//         };

//         PriorityQueue<int[]> pq = new PriorityQueue<>(customComparator);
        
//         for(int i=0; i<n; ++i){
//             pq.offer(new int[]{i, 0});
//         }
        
//         for(int i=0; i<meetings.length; ++i){
//             // if(pq.isEmpty() || (pq.peek()[1]>meetings[i][0] && pq.size()<n)){
//             //     pq.offer(new int[]{pq.size(), meetings[i][1]});
//             //     continue;
//             // }
            
//             int st = meetings[i][0];
//             int end = meetings[i][1];
            
//             if(pq.peek()[1] < st){
//                 PriorityQueue<Integer> pq2 = new PriorityQueue<>();
//                 while(!pq.isEmpty() && pq.peek()[1] < st) pq2.offer(pq.poll()[0]);
//                 int curRoom = pq2.poll();
//                 ++rooms[curRoom];
//                 mx = Math.max(mx, rooms[curRoom]);
//                 pq.offer(new int[]{curRoom, end});
//                 while(!pq2.isEmpty()) pq.offer(new int[]{pq2.poll(), end});
//             }
//             else{
            
//                 int[] cur = pq.poll();
//                 ++rooms[cur[0]];
//                 mx = Math.max(mx, rooms[cur[0]]);
//                 int[] next = new int[]{cur[0], Math.max(end, cur[1]+end)};
//                 pq.offer(next);
//             }
//         }
//         System.out.println(Arrays.toString(rooms));
//         for(int i=0; i<n; ++i) if(rooms[i]==mx) return i;
//         return -1;
//     }
// }