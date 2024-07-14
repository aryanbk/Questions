class Solution {
    int n;
    public String countOfAtoms(String fml) {
        n = fml.length();
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
        var map = new TreeMap<String, Integer>();
        
        while(i<n){
            String cur;
            int num = 1;
            int newI = i+1;

            
            if(fml.charAt(i) == '('){
                Map<String, Integer> res = solve(i+1, fml);
                
                for(String key: res.keySet())
                    map.put(key, map.getOrDefault(key, 0) + res.get(key));
                int a = i+1;
                int open = 1;
                for(; a<n && open!=0; ++a){
                    if(fml.charAt(a)=='(') ++open;
                    if(fml.charAt(a)==')') --open;
                }
                
                for(; a<n && help(fml.charAt(a))==0; ++a);
                newI = a;
            }
            else if(fml.charAt(i) == ')'){ // if it is ) then add up return current map
                int a = i+1;
                for(; a<n && help(fml.charAt(a))==0; ++a);
                int mlt = a==i+1 ? 1 : Integer.parseInt(fml.substring(i+1, a));
                for(String key: map.keySet())
                    map.put(key, map.get(key)*mlt);
                return map;
            }
            else{
                if(i==n-1) cur = fml.substring(i, i+1);
                else {
                    int next = help(fml.charAt(i+1));
                    if(next != -1){ // next is not lower
                        cur = fml.substring(i, i+1);
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
            i = newI;
        }
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