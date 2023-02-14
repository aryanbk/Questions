# class Solution:
#     def leastInterval(self, tasks: List[str], n: int) -> int:
#         c = Counter(tasks)
#         hp = [(-v, k) for k, v in c.items()]
#         heapify(hp)
#         time=0
#         # mp=defaultdict(int)
#         s = set()
#         q = []
#         for _ in range(n): q.append(None)
#         while hp:
#             q0 = q.pop(0)
#             if q0:
#                 s.remove(q0)
#             v, k = hp[0]
#             # if (k not in mp or mp[k]==0) and v!=0:
#             #     v*=-1
#             #     time+=1
#             #     a, b = heappop(hp)
#             #     heappush(hp, [a+1, b])
#             if k not in s:
#                 a, b = heappop(hp)
#                 q.append(b)
#                 set.add
#                 if a<-1:
#                     heappush(hp, (a+1, b))
            
                
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        c = Counter(tasks).values()
        hp = [-a for a in c]
        heapify(hp)
        time=0
        while hp:
            stk, i = [], 0
            while hp and i<n+1:
                popped = heappop(hp)+1
                if popped != 0: stk.append(popped)
                i+=1
                if not hp and not stk: return time+i
            while stk: heappush(hp, stk.pop())
            time+=n+1
        return time
            
            