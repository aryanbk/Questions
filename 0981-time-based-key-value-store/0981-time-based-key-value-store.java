class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
            map.get(key).add(new Pair("", 0));
        }
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> pairs = map.getOrDefault(key, null);
        if(pairs == null) return "";
        
        int idx = Collections.binarySearch(pairs, new Pair("", timestamp),
                                          (a, b) -> a.time-b.time);
        if(idx < 0) idx = (idx + 2)*-1;
        
        return pairs.get(idx).val;
    }
}

class Pair {
    String val;
    int time;
    
    public Pair(String v, int t) {
        val = v;
        time = t;
    }
}





// class TimeMap {
//     Map<String, List<Pair>> map;
//     public TimeMap() {
//         map = new HashMap<>();
//     }
    
//     public void set(String key, String value, int timestamp) {
//         if(!map.containsKey(key)){
//             map.put(key, new ArrayList<>());
//             map.get(key).add(new Pair("", 0));
//         }
//         map.get(key).add(new Pair(value, timestamp));
//     }
    
//     public String get(String key, int timestamp) {
//         List<Pair> pairs = map.getOrDefault(key, null);
//         if(pairs == null) return "";
        
//         int idx = Collections.binarySearch(pairs, new Pair("", timestamp));
//         if(idx < 0) idx = (idx + 2)*-1;
        
//         return pairs.get(idx).val;
//     }
// }

// class Pair implements Comparable<Pair>{
//     String val;
//     int time;
//     public Pair(String v, int t){
//         val = v;
//         time = t;
//     }
//     @Override
//     public int compareTo(Pair other){
//         return this.time - other.time;
//     }
// }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */