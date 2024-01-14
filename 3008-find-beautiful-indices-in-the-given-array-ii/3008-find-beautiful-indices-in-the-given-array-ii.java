class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> aa = strStr(s, a);
        List<Integer> bb = strStr(s, b);
        List<Integer> ans = new ArrayList<>();
        
        for (var x : aa) {
            if (bs(bb, x, k)) ans.add(x);
        }

        return ans;
    }

    boolean bs(List<Integer> arr, int x, int k) {
        int lo = 0;
        int hi = arr.size() - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if(Math.abs(arr.get(mid) - x) <= k)
                return true;
            else if (arr.get(mid) < x)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return false;
    }

    public List<Integer> strStr(String hay, String needle) {
        List<Integer> ans = new ArrayList<>();

        int n = needle.length();
        int h = hay.length();

        // Finding LPS O(n)
        int[] lps = new int[n];
        int prev = 0;
        int cur = 1;

        while (cur < n) {
            if (needle.charAt(prev) == needle.charAt(cur)) {
                lps[cur] = prev + 1;
                ++prev;
                ++cur;
            } else if (prev == 0) {
                lps[cur] = 0;
                ++cur;
            } else {
                prev = lps[prev - 1];
            }
        }

        int i = 0;
        int j = 0;

        while (i < h) {
            if (hay.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            }
            if (j == n) {
                ans.add(i - n);
                j = lps[j - 1];
            } else if (i < h && hay.charAt(i) != needle.charAt(j)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    ++i;
            }
        }

        return ans;
    }
}





// class Solution {
//     public List<Integer> beautifulIndices(String s, String a, String b, int k) {
//         List<Integer> aa = strStr(s, a);
//         List<Integer> bb = strStr(s, b);
//         List<Integer> ans = new ArrayList<>();
        
        
//         for(var x: aa){
//             int idx = bs(bb, x);
//             if(idx<0) idx = (idx+1)*-1;
//             if(Math.abs(bb.get(idx)) <= k)
//                 ans.add(x);
//         }
        
//         return ans;
//     }
    
//     int bs(List<Integer> arr, int x){
//         int lo = 0;
//         int hi = arr.size()-1;
//         while(lo<=hi){
//             int mid = lo + (hi-lo)/2;
//             if(arr.get(mid)<x)
//                 lo = mid + 1;
//             else
//                 hi = mid -1;
//         }
//         return lo;
//     }

//     public List<Integer> strStr(String hay, String needle) {
        
//         List<Integer> ans = new ArrayList<>();
        
//         int n = needle.length();
//         int h = hay.length();
        
//         // Finding LPS O(n)
//         int[] lps = new int[n];
//         int prev = 0;
//         int cur = 1;
        
//         while(cur < n){
//             if(needle.charAt(prev) == needle.charAt(cur)){
//                 lps[cur] = prev + 1;
//                 ++prev;
//                 ++cur;
//             }
//             else if(prev==0){
//                 lps[cur] = 0;
//                 ++cur;
//             }
//             else{
//                 prev = lps[prev - 1];
//             }
//         }
        
//         int i = 0;
//         int j = 0;
        
//         while (i < h && j < n) {
//             if(j==n){
//                 ans.add(i-n);
//             }
//             if(hay.charAt(i) == needle.charAt(j)){
//                 ++i;
//                 ++j;
//             }
//             else if(j == 0){
//                 ++i;
//             }
//             else{
//                 j = lps[j-1];
//             }
//         }
        
//         return ans;
//     }
// }