class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] ans = new int[n];
        Arrays.sort(deck);
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0; i<n; ++i) dq.offerLast(i);
        
        for(int i=0;; ++i){
            int polled = dq.pollFirst();
            ans[polled] = deck[i];
            
            if(dq.isEmpty()) return ans;
            dq.offerLast(dq.pollFirst());
        }
    }
}