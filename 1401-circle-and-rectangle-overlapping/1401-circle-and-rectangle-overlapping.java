class Solution {
    public boolean checkOverlap(int radius, int x, int y, int x1, int y1, int x2, int y2) {
        x1 -= x;
        x2 -= x;
        y1 -= y;
        y2 -= y;
        
        int mnx = x1*x2 > 0 ? Math.min(x1*x1, x2*x2) : 0;
        int mny = y1*y2 > 0 ? Math.min(y1*y1, y2*y2) : 0;
        
        return mnx + mny <= radius*radius;
    }
}