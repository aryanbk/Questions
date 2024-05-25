class Solution:
    def queryResults(self, limit: int, qq: List[List[int]]) -> List[int]:
        map = {}
        c = {}
        ans = [0] * len(qq)
        i=0
        for q in qq:
            if q[0] not in c:
                c[q[0]] = q[1]
                map[q[1]] = map.get(q[1], 0)+1;
            else:
                prev = c[q[0]]
                map[prev]-=1;
                if map[prev]==0:
                    map.pop(prev)
                c[q[0]] = q[1]
                map[q[1]] = map.get(q[1], 0)+1;
            ans[i] = len(map)
            i+=1;
        
        return ans