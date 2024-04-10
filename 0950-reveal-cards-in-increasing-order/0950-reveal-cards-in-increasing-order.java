class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] ans = new int[n];
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; ++i) q.offer(i);
        
        for(int i=0;; ++i){
            ans[q.poll()] = deck[i];
            
            if(q.isEmpty()) return ans;
            q.offer(q.poll());
        }
    }
}




// class Solution {
//     public int[] deckRevealedIncreasing(int[] deck) {
//         int n = deck.length;
//         int[] ans = new int[n];
//         Arrays.sort(deck);
//         Deque<Integer> dq = new LinkedList<>();
//         for(int i=0; i<n; ++i) dq.offerLast(i);
        
//         for(int i=0;; ++i){
//             int polled = dq.pollFirst();
//             ans[polled] = deck[i];
            
//             if(dq.isEmpty()) return ans;
//             dq.offerLast(dq.pollFirst());
//         }
//     }
// }