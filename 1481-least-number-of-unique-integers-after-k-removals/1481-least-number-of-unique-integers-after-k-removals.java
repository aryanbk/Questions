class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: arr){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        Map<Integer, List<Integer>> freq = new HashMap<>();
        int mx = 0;
        int unique = map.size();
        for(int key: map.keySet()){
            int val = map.get(key);
            mx = Math.max(mx, val);
            if(!freq.containsKey(val))
                freq.put(val, new ArrayList<>());
            freq.get(val).add(key);
        }
        // System.out.println(mx+" "+unique+" "+freq);
        for(int i=1; i<=mx && k>0; ++i){
            if(!freq.containsKey(i)) continue;
            int n = freq.get(i).size();
            int tot = n*i;
            if(k >= tot){
                unique -= n;
                k -=  tot;
            }
            else{
                unique -= k/i;
                break;
            }
        }
        
        return unique;
    }
}