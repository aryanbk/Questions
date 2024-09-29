class AllOne {
    
    Map<String, Integer> map;
    TreeMap<Integer, Set<String>> remap;
    public AllOne() {
        map = new HashMap<>();
        remap = new TreeMap<>();
    }
    
    public void inc(String key) {
        int freq = map.getOrDefault(key, 0);
        map.put(key, freq+1);
        remap.putIfAbsent(freq+1, new HashSet<>());
        remap.get(freq+1).add(key);
        
        if(freq != 0) remove(freq, key);
    }
    
    public void dec(String key) {
        int freq = map.getOrDefault(key, 0);
        if(freq != 1){
            map.put(key, freq-1);
            remap.putIfAbsent(freq-1, new HashSet<>());
            remap.get(freq-1).add(key);
        }
        else map.remove(key);
        
        remove(freq, key);
    }
    
    public String getMaxKey() {
        if(remap.size() == 0) return "";
        return remap.get(remap.lastKey()).iterator().next();
    }
    
    public String getMinKey() {
        if(remap.size() == 0) return "";
        return remap.get(remap.firstKey()).iterator().next();
    }
    
    void remove(int num, String str){
        remap.get(num).remove(str);
        if(remap.get(num).size() == 0) remap.remove(num);
    }
}



// // readable code============

// class AllOne {
    
//     Map<String, Integer> map;
//     TreeMap<Integer, Set<String>> remap;
//     public AllOne() {
//         map = new HashMap<>();
//         remap = new TreeMap<>();
//     }
    
//     public void inc(String key) {
//         int freq = map.getOrDefault(key, 0);
//         map.put(key, freq+1);
//         remap.putIfAbsent(freq+1, new HashSet<>());
//         remap.get(freq+1).add(key);
//         if(freq != 0){
//             remap.get(freq).remove(key);
//             if(remap.get(freq).size() == 0) remap.remove(freq);
//         }
//     }
    
//     public void dec(String key) {
//         int freq = map.getOrDefault(key, 0);
//         if(freq != 1){
//             map.put(key, freq-1);
//             remap.putIfAbsent(freq-1, new HashSet<>());
//             remap.get(freq-1).add(key);
//         }
//         else map.remove(key);
        
//         remap.get(freq).remove(key);
//         if(remap.get(freq).size() == 0) remap.remove(freq);
//     }
    
//     public String getMaxKey() {
//         if(remap.size() == 0) return "";
//         int mxKey = remap.lastKey();
//         Iterator<String> iterator = remap.get(mxKey).iterator();
//         return iterator.next();
//     }
    
//     public String getMinKey() {
//         if(remap.size() == 0) return "";
//         int mnKey = remap.firstKey();
//         Iterator<String> iterator = remap.get(mnKey).iterator();
//         return iterator.next();
//     }
// }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */