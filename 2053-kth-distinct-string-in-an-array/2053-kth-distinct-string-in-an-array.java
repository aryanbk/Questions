class Solution {
    public String kthDistinct(String[] arr, int k) {
        var all = new HashSet<String>();
        var repeat = new HashSet<String>();
        for(String s: arr){
            if(all.contains(s)) repeat.add(s);
            else all.add(s);
        }
        for(int i=0; i<arr.length; ++i){
            if(!repeat.contains(arr[i])) --k;
            if(k==0) return arr[i];
        }
        return "";
    }
}



// class Solution {
//     public String kthDistinct(String[] arr, int k) {
//         TreeMap<String, Boolean> map = new TreeMap<>();
//         for(String s: arr){
//             if(map.containsKey(s)) map.put(s, false);
//             else map.put(s, true);
//         }
//         System.out.println(map);
//         for(Map.Entry<String, Boolean> entry: map.entrySet()){
//             if(entry.getValue()) --k;
//             if(k==0) return entry.getKey();
//         }
//         return "";
//     }
// }