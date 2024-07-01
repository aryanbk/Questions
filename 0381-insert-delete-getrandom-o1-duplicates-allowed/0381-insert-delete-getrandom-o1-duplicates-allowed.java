class RandomizedCollection {
    
    Map<Integer, List<Integer>> map;
    List<Integer> list;
    int n;
    Random r;
    
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        n = 0;
        r = new Random();
    }
    
    public boolean insert(int val) {
        // System.out.println(map+" "+list+" insert "+val);
        list.add(val);
        map.putIfAbsent(val, new ArrayList<>());
        map.get(val).add(n);
        ++n;
        return map.get(val).size()==1;
    }
    
    public boolean remove(int val) {
        // System.out.println(map+" "+list+" remove "+val);
        if(!map.containsKey(val) || map.get(val).size()==0) return false;
        if(val ==  list.get(n-1)){
            var idxList = map.get(val);
            idxList.remove(idxList.size()-1);
            list.remove(n-1);
            --n;
            return true;
        }
        
        var idxList = map.get(val);
        // int idxSize = idxList.size();
        int idx = map.get(val).get(idxList.size() - 1);
        
        int repVal = list.get(n-1);
        var repList = map.get(repVal);
        list.set(idx, repVal);
        
        idxList.remove(idxList.size()-1);
        // mrepList.remove(repList.size() - 1);
        for(int i=0; i<repList.size(); ++i){
            if(repList.get(i)==n-1){
                repList.set(i, idx);
                break;
            }
        }
        list.remove(n-1);
        --n;
        return true;
        
    }
    
    public int getRandom() {
        // System.out.println(map);
        // System.out.println(list);
        return list.get(r.nextInt(n));
    }
}











// // First attempt
//
// class RandomizedCollection {
    
//     Map<Integer> map;
//     int items;
//     Random r;
    
//     public RandomizedCollection() {
//         map = new HashMap<>();
//         items = 0;
//         r = new Random();
//     }
    
//     public boolean insert(int val) {
//         map.put(val, map.getOrDefault(val, 0)+1);
//         ++items;
//         return map.get(val)==1;
//     }
    
//     public boolean remove(int val) {
//         if(map.containsKey(val)){
//             map.put(val, map.get(val)-1);
//             if(map.get(val)==0)
//                 map.remove(val);
//             --items;
//             return true;
//         }
//         return false;
//     }
    
//     public int getRandom() {
//         int x = r.nextInt(items);
//         int cur = 0;
//         // for(int i)
//     }
// }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */