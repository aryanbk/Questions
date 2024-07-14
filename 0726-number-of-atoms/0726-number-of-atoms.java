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
        Map<String, Integer> map = solve(0, fml);
        var sb = new StringBuilder();
        for(String key: map.keySet()){
            int val = map.get(key);
            sb.append(key);
            if(val != 1) sb.append(Integer.toString(val));
        }
        
        return sb.toString();
        
    }
    
    Map<String, Integer> solve(int i, String fml){
        // System.out.println(i);
        // var map = new TreeMap<String, Integer>(Collections.reverseOrder());
        var map = new TreeMap<String, Integer>();
        
        while(i<n){
            String cur;
            int num = 1;
            int newI = i+1;

            
            if(fml.charAt(i) == '('){
                Map<String, Integer> res = solve(i+1, fml);
                // System.out.println("res===="+res+" map===="+map);
                // System.out.println(res);
//                 int a = bkt[i]+1;
//                 int mlt = 1;
//                 newI = a;
                
//                 if(a<=j && help(fml.charAt(a)) == 0){
//                     for(; a<=j && help(fml.charAt(a))==0; ++a);
//                     mlt = Integer.parseInt(fml.substring(bkt[i]+1, a));
//                     newI = a;
//                 }
                
                // System.out.println(i+" "+bkt[i]+" "+mlt);
                for(String key: res.keySet())
                    map.put(key, map.getOrDefault(key, 0) + res.get(key));
                int a = i+1;
                int open = 1;
                for(; a<n && open!=0; ++a){
                    if(fml.charAt(a)=='(') ++open;
                    if(fml.charAt(a)==')') --open;
                }
                // System.out.println(a);
                // ++a;
                for(; a<n && help(fml.charAt(a))==0; ++a);
                newI = a;
                // System.out.println(i+" "+a+" "+map);
            }
            else if(fml.charAt(i) == ')'){
                int a = i+1;
                for(; a<n && help(fml.charAt(a))==0; ++a);
                int mlt = a==i+1 ? 1 : Integer.parseInt(fml.substring(i+1, a));
                for(String key: map.keySet())
                    map.put(key, map.get(key)*mlt);
                // System.out.println(i+" "+map+" "+mlt);
                return map;
            }
            else{
                if(i==n-1) cur = fml.substring(i, i+1);
                else {
                    int next = help(fml.charAt(i+1));
                    if(next != -1){ // next is not lower
                        cur = fml.substring(i, i+1);
                        // System.out.println("cur--"+cur);
                        // cur = Character.toString(fml.charAt(i));
                        if(next == 0){
                            int a = i+1;
                            for(; a<n && help(fml.charAt(a))==0; ++a);
                            num = Integer.parseInt(fml.substring(i+1, a));
                            newI = a;
                        }
                    }
                    else{
                        // Two char elements
                        cur = fml.substring(i, i+2);
                        newI = i+2;
                        if(i+2<=n && help(fml.charAt(i+2)) == 0){
                            int a = i+2;
                            for(; a<n && help(fml.charAt(a))==0; ++a);
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