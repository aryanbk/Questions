class Solution:
    def eraseOverlapIntervals(self, intv: List[List[int]]) -> int:
        intv.sort()
        start, remove = intv[-1][0], 0
        
        for i in range(len(intv)-2, -1, -1):
            if intv[i][1] <= start:
                start = intv[i][0]
            else:
                remove += 1
        return remove
        