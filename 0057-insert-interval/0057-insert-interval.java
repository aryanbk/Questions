// O(logn + n)

class Solution {
    public int[][] insert(int[][] intvl, int[] newIntvl) {
        List<int[]> ans = new ArrayList<>();
        int idx = bs(intvl, newIntvl[0]);
        
        for(int i=0; i<idx; ++i) ans.add(intvl[i]);
        int i = ans.size();
        
        if(i!=0 && ans.get(i-1)[1] >= newIntvl[0])
            ans.get(i-1)[1] = Math.max(newIntvl[1], ans.get(i-1)[1]);
        else
            ans.add(newIntvl);
        
        for(; i<intvl.length; ++i){
            if(ans.get(ans.size()-1)[1] >= intvl[i][0])
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], intvl[i][1]);
            else
                ans.add(intvl[i]);
        }
        int[][] res = new int[ans.size()][2];
        for(int j=0; j<ans.size(); ++j) res[j] = ans.get(j);
        return res;
    }
    
    int bs(int[][] arr, int x){
        int i=0;
        int j=arr.length;
        while(i<j){
            int mid = i+(j-i)/2;
            if(arr[mid][0] < x) i=mid + 1;
            else j = mid;
        }
        return j;
    }
}