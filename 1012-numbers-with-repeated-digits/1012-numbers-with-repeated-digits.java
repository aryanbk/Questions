class Solution {
    Map<CustomKey, Integer> map;
    public int numDupDigitsAtMostN(int n) {
        String str = Integer.toString(n);
        map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<10; ++i) list.add(0);
        
        return n - dp(0, list, 0, 1, str) + 1;
    }

    int dp(int i, List<Integer> vis, int allow, int zero, String str){
        if(i == str.length()) return 1;
        CustomKey key = new CustomKey(i, allow, zero, vis);
        
        if(map.containsKey(key)) return map.get(key);
        
        int limit = allow==1 ? 9 : str.charAt(i)-'0';
        int ans = 0;
        
        for(int x=0; x<=limit; ++x){
            int newAllow = (allow==1 || x<limit) ? 1 : 0;
            
            if(zero==1 && x==0){
                ans += dp(i+1, vis, newAllow, 1, str);
                continue;
            }
            if(vis.get(x) > 0) continue;
            // int newPrev = prev==10 && x==0 ? 10 : x;
            vis.set(x, vis.get(x)+1);
            ans += dp(i+1, vis, newAllow, 0, str);
            vis.set(x, vis.get(x)-1);
        }
        map.put(key, ans);
        return ans;
    }
}



public class CustomKey {
    private int num1;
    private int num2;
    private int num3;
    private List<Integer> list;

    public CustomKey(int num1, int num2, int num3, List<Integer> list) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.list = list;
    }

    // You can override equals and hashCode for proper HashMap key functionality

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomKey customKey = (CustomKey) o;
        return num1 == customKey.num1 &&
                num2 == customKey.num2 &&
                num3 == customKey.num3 &&
                Objects.equals(list, customKey.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num1, num2, list);
    }
}

// https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/