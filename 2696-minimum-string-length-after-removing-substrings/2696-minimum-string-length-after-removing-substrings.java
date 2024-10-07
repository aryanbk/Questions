class Solution {
    public int minLength(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(int i=0; i<s.length(); ++i){
            char c = s.charAt(i);
            if(c=='B' && !dq.isEmpty() && dq.peekLast()=='A') dq.pollLast();
            else if(c=='D' && !dq.isEmpty() && dq.peekLast()=='C') dq.pollLast();
            else dq.offerLast(c);
        }
        return dq.size();
    }
}