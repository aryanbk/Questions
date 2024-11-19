class Solution {
    boolean[] vis = new boolean[50001];
    public boolean canReach(int[] arr, int start) {
        if(start < 0 || start >= arr.length || vis[start]) return false;
        if(arr[start]==0) return true;
        vis[start] = true;
        return canReach(arr, start-arr[start]) || canReach(arr, start+arr[start]);
    }
}