class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int dx = Math.abs(fx-sx);
        int dy = Math.abs(fy-sy);
        if(dx==0 && dy==0)
            return t!=1;
        int mn = Math.min(dx, dy);
        int straight = Math.max(dx, dy) - mn;
        return t>=mn+straight;
    }
}