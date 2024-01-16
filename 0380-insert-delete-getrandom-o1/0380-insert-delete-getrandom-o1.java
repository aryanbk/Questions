class RandomizedSet {
    
    Map<Integer, Integer> map;
    List<Integer> list;
    Random r;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int idx = map.get(val);
            if(idx != list.size()-1){
                int last = list.get(list.size() - 1);
                map.put(last, idx);
                list.set(idx, last);
            }
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int idx = r.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */