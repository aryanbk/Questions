class Solution {
    
    int MOD = 1000000007;
    Map<Key, Integer> map;
    
    public int count(String num1, String num2, int min_sum, int max_sum) {
        map = new HashMap<>();
        int diff = num2.length() - num1.length();
        num1 = "0".repeat(diff) + num1;
        return solve(0, 0, 0, min_sum, max_sum, num1, num2);
    }
    
    int solve(int i, int allow1, int allow2, int mn, int mx, String str1, String str2){
        if(i==str1.length())
            return mn<=0 && mx>=0 ? 1 : 0;
        
        Key key = new Key(i, allow1, allow2, mn, mx);
        if(map.containsKey(key)) return map.get(key);
        
        int start = allow1==1 ? 0 : str1.charAt(i)-'0';
        int end = allow2==1 ? 9 : str2.charAt(i)-'0';
        int ans = 0;
        
        for(int x=start; x<=end; ++x){
            int newAllow1 = (allow1==1 || x>start) ? 1 : 0;
            int newAllow2 = (allow2==1 || x<end) ? 1 : 0;
            if(mx-x<0) continue;
            ans = (ans + solve(i+1, newAllow1, newAllow2, mn-x, mx-x, str1, str2))%MOD;
        }
        
        map.put(key, ans);
        return ans;
    }
}


class Key {
    int i;
    int allow1;
    int allow2;
    int mn;
    int mx;

    public Key(int i, int allow1, int allow2, int mn, int mx) {
        this.i = i;
        this.allow1 = allow1;
        this.allow2 = allow2;
        this.mn = mn;
        this.mx = mx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key other = (Key) o;
        return i == other.i && allow1 == other.allow1 &&
                allow2 == other.allow2 && mn == other.mn &&
                mx == other.mx;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, allow1, allow2, mn, mx);
    }
}
