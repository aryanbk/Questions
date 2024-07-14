class Solution {
    int n;
    int[] bkt;
    public String countOfAtoms(String fml) {
        n = fml.length();
        bkt = new int[n];
        var stk = new ArrayDeque<Integer>();
        for(int i=0; i<n; ++i){
            char c = fml.charAt(i);
            if(help(c) == 2) stk.offerLast(i);
            if(help(c) == -2){
                int open = stk.pollLast();
                bkt[open] = i;
                // bkt[i] = open;
                // System.out.println(open+" "+i);
            }
        }
        // System.out.println(Arrays.toString(bkt));
        
//         var map = new TreeMap<Character, Integer>();
//         var sb = new StringBuilder();
//         for(int i=0; i<n; ++i){
//             char c = s.charAt(i);
            
//         }
        Map<String, Integer> map = solve(0, n-1, fml);
        var sb = new StringBuilder();
        for(String key: map.keySet()){
            int val = map.get(key);
            sb.append(key);
            if(val != 1) sb.append(Integer.toString(val));
        }
        
        return sb.toString();
        
    }
    
    Map<String, Integer> solve(int i, int j, String fml){
        // var map = new TreeMap<String, Integer>(Collections.reverseOrder());
        var map = new TreeMap<String, Integer>();
        
        while(i<=j){
            String cur;
            int num = 1;
            int newI = i+1;


            if(fml.charAt(i) == '('){
                Map<String, Integer> res = solve(i+1, bkt[i]-1, fml);
                // System.out.println(res);
                int k = bkt[i]+1;
                int mlt = 1;
                newI = k;
                
                if(k<=j && help(fml.charAt(k)) == 0){
                    for(; k<=j && help(fml.charAt(k))==0; ++k);
                    mlt = Integer.parseInt(fml.substring(bkt[i]+1, k));
                    newI = k;
                }
                
                // System.out.println(i+" "+bkt[i]+" "+mlt);
                for(String key: res.keySet()){
                    int prev = map.getOrDefault(key, 0);
                    map.put(key, prev + (res.get(key)*mlt));
                }
            }
            else if(fml.charAt(i) == ')') return map;
            else{
                if(i==j) cur = fml.substring(i, i+1);
                else {
                    int next = help(fml.charAt(i+1));
                    if(next != -1){ // next is not lower
                        cur = fml.substring(i, i+1);
                        // System.out.println("cur--"+cur);
                        // cur = Character.toString(fml.charAt(i));
                        if(next == 0){
                            int a = i+1;
                            for(; a<=j && help(fml.charAt(a))==0; ++a);
                            num = Integer.parseInt(fml.substring(i+1, a));
                            newI = a;
                        }
                    }
                    else{
                        // Two char elements
                        cur = fml.substring(i, i+2);
                        newI = i+2;
                        if(i+2<=j && help(fml.charAt(i+2)) == 0){
                            int a = i+2;
                            for(; a<=j && help(fml.charAt(a))==0; ++a);
                            num = Integer.parseInt(fml.substring(i+2, a));
                            newI = a;
                        }
                    }
                }
                map.put(cur, map.getOrDefault(cur, 0) + num);
            } 
            // System.out.println("map----"+map);
            i = newI;
        }
        // System.out.println(map);
        return map;
    }
    
    int help(char c){
        if(c>='a' && c<='z') return -1;
        if(c>='0' && c<='9') return 0;
        if(c>='A' && c<='Z') return 1;
        if(c=='(') return 2;
        if(c==')') return -2;
        return -100;
    }
}