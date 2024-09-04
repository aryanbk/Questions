class Solution {
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int x = 0;
    int[] cur = {0, 0};
    // Set<List<Integer>> obs;
    public int robotSim(int[] cmd, int[][] obs) {
        Map<Integer, List<Integer>> obsx = new HashMap<>();
        Map<Integer, List<Integer>> obsy = new HashMap<>();
        for(int[] o: obs){
            System.out.println(o[0]+" - "+o[1]);
            var listy = obsy.getOrDefault(o[0], new ArrayList<Integer>());
            listy.add(o[1]);
            obsy.put(o[0], listy);
            var listx = obsx.getOrDefault(o[1], new ArrayList<Integer>());
            listx.add(o[0]);
            obsx.put(o[1], listx);
        }
        System.out.println(obsx+" "+obsy);
        // obs = new HashSet<>();
        int ans = 0;
        
        for(int i=0; i<cmd.length; ++i){
            if(cmd[i]==-1){
                x+=1;
                continue;
            }
            else if(cmd[i]==-2){
                x+=3;
                continue;
            }
            int[] newCur = {cur[0] + (dir[x%4][0]*cmd[i]), cur[1] + dir[x%4][1]*cmd[i]};
            if(cur[0] == newCur[0] && obsy.containsKey(cur[0])){
                for(int k: obsy.get(cur[0])){
                    if((k-newCur[1]) * (k-cur[1]) <= 0 && k!=cur[1]){
                        newCur[1] = k + (cur[1] > newCur[1] ? 1 : -1);
                        // break;
                    }
                }
            }
            else if(cur[1] == newCur[1] && obsx.containsKey(cur[1])){
                for(int k: obsx.get(cur[1])){
                    if((k-newCur[0]) * (k-cur[0]) <= 0 && k!=cur[0]){
                        newCur[0] = k + (cur[0] > newCur[0] ? 1 : -1);
                        // break;
                    }
                }
            }
            cur = newCur;
            System.out.println(cur[0]+" "+cur[1]);
            ans = Math.max(ans, (cur[0]*cur[0]) + (cur[1]*cur[1]));
        }
        
        return ans;
    }
}