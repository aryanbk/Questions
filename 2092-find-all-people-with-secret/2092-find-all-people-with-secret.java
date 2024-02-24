// class Solution {
//     public List<Integer> findAllPeople(int n, int[][] meet, int f) {
//         Map<Integer, List<Integer>> map = new TreeMap<>();
//         for(int i=0; i<meet.length; ++i){
//             if(!map.containsKey(meet[i][2])) map.put(meet[i][2], new ArrayList<>());
//             map.get(meet[i][2]).add(meet[i][0]);
//             map.get(meet[i][2]).add(meet[i][1]);
//         }
        
//         boolean[] know = new boolean[n];
//         know[0] = know[f] = true;
//         Set<Integer> set = new HashSet<>();
//         set.add(0);
//         set.add(f);
        
//         for(int k: map.keySet()){
//             var list = map.get(k);
//             boolean anyKnow = false;
//             for(int i=0; i<list.size() && !anyKnow; ++i){
//                 anyKnow = anyKnow || know[list.get(i)];
//             }
//             if(anyKnow){
//                 for(int i: list){
//                     know[i] = true;
//                     set.add(i);
//                 }
//             }
//         }
//         return set.stream().collect(Collectors.toList());  

//     }
// }




// class Solution {
//     public List<Integer> findAllPeople(int n, int[][] meet, int f) {
//         Arrays.sort(meet, (a, b)->a[2]-b[2]);
//         boolean[] s = new boolean[n];
//         s[0] = true;
//         s[f] = true;
//         for(int i=0; i<meet.length;){
//             int time = meet[i][2];
//             Map<Integer, Integer> map = new HashMap<>();
//             while(meet[i][2] == time){
                
//             }
//             if(s[meet[i][0]] || s[meet[i][1]]){
//                 s[meet[i][0]] = s[meet[i][1]] = true;
//             }
//         }
//         List<Integer> ans = new ArrayList<>();
//         for(int i=0; i<n; ++i){
//             if(s[i]) ans.add(i);
//         }
//         return ans;
//     }
// }


class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> added = new HashSet<>();
        
        PriorityQueue<int[]> known = new PriorityQueue<>((p0, p1) -> p0[1] - p1[1]);
        known.offer(new int[]{0, 0});
        known.offer(new int[]{firstPerson, 0});
        
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] meeting : meetings) {
            map.putIfAbsent(meeting[0], new ArrayList<>());
            map.putIfAbsent(meeting[1], new ArrayList<>());
            
            map.get(meeting[0]).add(new int[]{meeting[1], meeting[2]});
            map.get(meeting[1]).add(new int[]{meeting[0], meeting[2]});
        }
        
        while (!known.isEmpty()) {
            int[] p = known.poll();
            
            if (!added.contains(p[0])) {
                added.add(p[0]);
                ans.add(p[0]);
            }
            
            if (!map.containsKey(p[0])) continue;
            
            List<int[]> meetAndTime = map.get(p[0]);
            for (int[] m : meetAndTime) {
                if (m[1] < p[1]) continue;
                
                known.offer(new int[]{m[0], m[1]});
            }
            
            map.remove(p[0]);
        }

        return ans;
    }
}
