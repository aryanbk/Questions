class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        m = defaultdict(int)
        for mt in matches:
            m[mt[0]] = m.get(mt[0], 0)
            m[mt[1]] = m.get(mt[1], 0)+1
        
        zero = []
        one = []
        
        for k,v in m.items():
            if v==0:
                zero.append(k)
            elif v==1:
                one.append(k)
        
        zero.sort()
        one.sort()
        return [zero, one]