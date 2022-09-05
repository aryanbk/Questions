class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> hp = new PriorityQueue<>();
        for(int i: nums){
            hp.add(i);
            if(hp.size()>k) hp.poll();
        }
        return hp.peek();
    }
}