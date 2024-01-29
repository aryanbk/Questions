class Solution {
    public int[][] intervalIntersection(int[][] first, int[][] sec) {
        Arrays.sort(first, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(sec, Comparator.comparingInt(a -> a[0]));
        
        int n1 = first.length;
        int n2 = sec.length;
        if(n1==0 || n2==0) return new int[0][0];

        int i=0;
        int j=0;
        
        List<int[]> list = new ArrayList<>();
        while(i<n1 && j<n2){
            int start = Math.max(first[i][0], sec[j][0]);
            int end = Math.min(first[i][1], sec[j][1]);
            
            if(start<=end){
                list.add(new int[]{start, end});
            }
            if(first[i][1] < sec[j][1]) ++i;
            else ++j;
        }
        
        int[][] ans = new int[list.size()][2];
        for(int x=0; x<list.size(); ++x)
            ans[x] = list.get(x);
        return ans;
    }
}