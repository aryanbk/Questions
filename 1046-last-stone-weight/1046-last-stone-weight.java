class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int s: stones) pq.add(s);
        while(pq.size()>1){
            int a=pq.poll();
            int b=pq.poll();
            int c=Math.abs(a-b);
            if(c!=0) pq.add(c);
        }
        return (pq.size()>0) ? pq.peek() : 0;
    }
}


// class Solution {
//     public int lastStoneWeight(int[] stones) { 
//         List<Integer> list=new ArrayList<>();
//         for(int i=0,l=stones.length; i<l; i++){
//             list.add(stones[i]);
//         }
//         return helper(list);
//     }
//     //
//     int helper(List<Integer> list){
//         int l=list.size();
//         if(l==0) return 0;
//         if(l==1) return list.get(0);
//         Collections.sort(list);
//         int diff=list.get(l-1)-list.get(l-2);
//         if(diff!=0){
//             list.set(l-1,diff);
//             list.remove(l-2);
//             return helper(list);
//         }else{
//             list.remove(l-1);
//             list.remove(l-2);
//             return helper(list);
//         }
//     }
// }

