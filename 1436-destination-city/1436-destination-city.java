class Solution {
    public String destCity(List<List<String>> paths) {
        var set = new HashSet<String>();
        for(var p : paths) set.add(p.get(0));
        
        for(var p: paths){
            if(!set.contains(p.get(1))) return p.get(1);
        }
        
        return "";
    }
}



// // first attempt
//
// class Solution {
//     public String destCity(List<List<String>> paths) {
//         // Map<String, String> adj = new HashMap<>();
//         // Map<String, Boolean> outDeg = new HashMap<>();
//         var set = new HashSet<String>();
//         for(var p : paths){
//             // adj.put(p.get(0), p.get(1));
//             // outDeg(p.get(0), false);
//             set.add(p.get(0));
//         }
//         // for(Str)
//         for(var p: paths){
//             if(!set.contains(p.get(1))){
//                 return p.get(1);
//             }
//         }
//         return "";
        
//     }
// }