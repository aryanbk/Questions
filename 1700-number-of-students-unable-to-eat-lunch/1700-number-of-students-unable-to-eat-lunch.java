class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stk = new Stack<>();
        
        for (int student : students) q.offer(student);
        for(int i=sandwiches.length-1; i>=0; --i) stk.push(sandwiches[i]);
        
        while(q.size() > 0 ){
            int n = q.size();
            for(int i=0; i<n; ++i){
                if(q.peek() == stk.peek()){
                    q.poll();
                    stk.pop();
                }
                else
                    q.offer(q.poll());
            }
            if(n == q.size()) return n;
        }
        
        return 0;
    }
}