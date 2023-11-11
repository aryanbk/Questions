class Solution:
    def maxSpending(self, values: List[List[int]]) -> int:
        n, m = len(values), len(values[0])
        
        ptr = [m-1]*n
        h = [(values[i][-1], i) for i in range(n)]
        heapify(h)
        
        ans, d = 0, 1
        
        while h:
            price, shop = heappop(h)
            ans += price*d
            
            if(ptr[shop]>0):
                ptr[shop]-=1
                heappush(h, (values[shop][ptr[shop]], shop))
            d+=1
        
        return ans