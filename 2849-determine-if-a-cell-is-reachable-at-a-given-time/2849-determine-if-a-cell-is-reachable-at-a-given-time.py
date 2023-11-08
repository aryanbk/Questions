class Solution:
    def isReachableAtTime(self, sx: int, sy: int, fx: int, fy: int, t: int) -> bool:
        dx, dy = abs(fx-sx), abs(fy-sy)
        if dx==0 and dy==0:
            return t!=1
        return t >= max(dx, dy)