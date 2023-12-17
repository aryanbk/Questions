class NumberContainers {
    
    Map<Integer, PriorityQueue<Integer>> map;
    Map<Integer, Integer> map2;
    
    public NumberContainers() {
        map = new HashMap<>();
        map2 = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(map2.containsKey(index)){ // check if given idx alredy assign to another num or not
            int prevNum = map2.get(index);
            map.get(prevNum).remove(index);
            // map.remove(index); // remove // this line cased WA#2 
            // it should be map2 here, if not remove then also fine
        }
        
        if(map.containsKey(number)){
            map.get(number).offer(index);
        }
        else{
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(index);
            map.put(number, pq);
        }
        map2.put(index, number);
    }
    
    public int find(int number) {
        return map.containsKey(number) && !map.get(number).isEmpty() ?
            map.get(number).peek() : -1;
    }
    // also check if pq isnt empty
    // otherwise will give null pointer
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */