// class Solution {
//     int[] parent;

//     public List<List<String>> accountsMerge(List<List<String>> acc) {
//         int n = acc.size();
//         parent = new int[n];
//         Arrays.fill(parent, -1); // Initialize parent array
        
//         Map<String, Integer> emailToIndex = new HashMap<>();

//         for (int i = 0; i < n; ++i) {
//             for (int j = 1; j < acc.get(i).size(); ++j) {
//                 String currentEmail = acc.get(i).get(j);
//                 if (!emailToIndex.containsKey(currentEmail)) {
//                     emailToIndex.put(currentEmail, i);
//                 } else {
//                     union(i, emailToIndex.get(currentEmail));
//                 }
//             }
//         }

//         // Collect merged accounts
//         Map<Integer, List<String>> mergedAccounts = new HashMap<>();
//         for (int i = 0; i < n; ++i) {
//             int root = find(i);
//             mergedAccounts.computeIfAbsent(root, key -> new ArrayList<>())
//                           .addAll(acc.get(i).subList(1, acc.get(i).size()));
//         }

//         // Create the result by sorting and combining the emails
//         List<List<String>> result = new ArrayList<>();
//         for (Map.Entry<Integer, List<String>> entry : mergedAccounts.entrySet()) {
//             List<String> currentList = entry.getValue();
//             Collections.sort(currentList);
//             List<String> account = new ArrayList<>();
//             account.add(acc.get(entry.getKey()).get(0)); // Add name
//             account.addAll(currentList); // Add sorted emails
//             result.add(account);
//         }

//         return result;
//     }

//     private void union(int i, int j) {
//         int rootI = find(i);
//         int rootJ = find(j);
//         if (rootI != rootJ) {
//             parent[rootI] = rootJ;
//         }
//     }

//     private int find(int i) {
//         if (parent[i] == -1) {
//             return i;
//         }
//         parent[i] = find(parent[i]); // Path compression
//         return parent[i];
//     }
// }



class Solution {
    int[] par;
    public List<List<String>> accountsMerge(List<List<String>> acc) {
        int total = 0;
        int n = acc.size();
        
        par = new int[n];
        Arrays.setAll(par, i->i);
        
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; ++i){
            for(int j=1; j<acc.get(i).size(); ++j){
                String cur = acc.get(i).get(j);
                if(map.containsKey(cur)){
                    // System.out.println(cur+" "+par[i]);
                    union(map.get(cur), i);
                }
                else{
                    map.put(cur, i);
                }
            }
        }
        
        for(String i: map.keySet()){
            System.out.println(i+" "+map.get(i));
        }
        System.out.println(Arrays.toString(par));
        
        Map<Integer, Set<String>> res = new HashMap<>();
        
        
        
        for(int i=0; i<acc.size(); ++i){
            // int p = find(i);
            int p = find(i);
            int m = acc.get(i).size();
            res.putIfAbsent(p, new HashSet<>());
            // for(int j = 1; j<acc.get(i).size(); ++j){
                // res.get
            // }
            
            res.get(p).addAll(acc.get(i).subList(1, m));

                
                
            // System.out.println(p+" "+i);
            // if(p == i){
            //     res.
            //     for(int j = 1; j<acc.get(i).size(); ++j){
            //         res.putIfAbsent(p)
            //     }
            // }
            // for(int j = 1; j<acc.get(i).size(); ++j)
            //     acc.get(p).add(acc.get(i).get(j));
            // acc.remove(i);
            // --i;
            
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(int i: res.keySet()){
            List<String> sub = new ArrayList<>(res.get(i));
            Collections.sort(sub);
            System.out.println(sub);
            List<String> subAns = new ArrayList<>();
            subAns.add(acc.get(i).get(0));
            subAns.addAll(sub);
            ans.add(subAns);
        }
        
        return ans;
        
        
        // for(int i=0; i<acc.size(); ++i){
        //     List<String> sub = acc.get(i).subList(1, acc.get(i).size());
        //     Collections.sort(sub);
        // }
        // return acc;
        
        
//         for(int i=0; i<n; ++i){
//             total += acc.get(i).size() - 1;
//         }
        
//         DJS djs = new DJS(total);
//         for(int i=0; i<n; ++i){
//             String f = acc.get(i).get(1);
//             for(int j=2; j<acc.get(i).size(); ++j){
//                 djs.union(f, acc.get(i).get(j));
//             }
//         }
        
//         Map<String, String> par = djs.getParent();
        
//         return null;
        
    }
    
    private int find(int i){
        int x = i;
        while(par[i] != i)
            i = par[i];
        par[x] = i;
        return par[x];
    }
    
    private void union(int i, int j){
        int rootI = find(i);
        int rootJ = find(j);
        if(rootI != rootJ)
            par[rootJ] = rootI;
    }
}

// class DJS {
//     private int[] parent;
//     private int[] rank;

//     public DJS(int size) {
//         parent = new int[size];
//         rank = new int[size];
//         for (int i = 0; i < size; i++) {
//             parent[i] = i; // Each element is its own parent initially
//             rank[i] = 0; // Initialize rank as 0
//         }
//     }

//     // Find the root/representative of the set
//     public int find(int x) {
//         if (parent[x] != x) {
//             parent[x] = find(parent[x]); // Path compression
//         }
//         return parent[x];
//     }

//     // Merge two sets by rank (Union by Rank)
//     public boolean union(int x, int y) {
//         int rootX = find(x);
//         int rootY = find(y);

//         if (rootX != rootY) {
//             if (rank[rootX] < rank[rootY]) {
//                 parent[rootX] = rootY;
//             } else if (rank[rootX] > rank[rootY]) {
//                 parent[rootY] = rootX;
//             } else {
//                 parent[rootY] = rootX;
//                 rank[rootX]++;
//             }
//             return true;
//         }
//         return false;
//     }
// }