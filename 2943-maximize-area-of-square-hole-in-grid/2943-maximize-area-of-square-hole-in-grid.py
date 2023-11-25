class Solution:
    def maximizeSquareHoleArea(self, n: int, m: int, hBars: List[int], vBars: List[int]) -> int:
        hBars.sort()
        vBars.sort()
        def find(bar, n):
            mx = 1
            cur = 1
            for i in range(1, len(bar)):
                if bar[i]-bar[i-1]==1:
                    cur += 1
                    mx = max(mx, cur)
                else:
                    cur = 1
            return mx+1
        
        return min(find(hBars, n), find(vBars, m))**2

# class Solution:
#     def maximizeSquareHoleArea(self, n: int, m: int, hBars: List[int], vBars: List[int]) -> int:
#         hBars.sort()
#         vBars.sort()
#         def find(hBars, n):
#             mx = 1
#             cur = 1
#             last  = 1
#             # for i in range(len(hBars)):
#             #     if hBars[i]-last==1:
#             #         cur += 1
#             #         mx = max(mx, cur)
#             #     else:
#             #         cur = 1
#             #     last = hBars[i]

#             for i in range(1, len(hBars)):
#                 if hBars[i]-hBars[i-1]==1:
#                     cur += 1
#                     mx = max(mx, cur)
#                 else:
#                     cur = 1
#                 # last = hBars[i]
            
#             # if cur==1 and hBars[-1]==n+2:
#                 # mx = max(mx, 2)
#             # print(mx)
#             # if n+2-hBars[-1]==1:
#             #     cur += 1
#             #     mx = max(mx, cur)
#             # else:
#             #     cur = 1
#             # print(mx, " ...")
#             return mx+1
        
#         return min(find(hBars, n), find(vBars, m))**2
                
#         # mxh = mx
#         # mx = 1
#         # cur =1
#         # last = 1
#         # for i in range(len(vBars)):
#         #     if vBars[i]-last==1:
#         #         cur += 1
#         #         mx = max(mx, cur)
#         #     else:
#         #         cur = 1
#         #     last = vBars[i]
#         # if m+2-vBars[-1]==1:
#         #     cur += 1
#         #     mx = max(mx, cur)
#         # else:
#         #     cur = 1
        
#         # print(mxh, mx)
#         # return min(mxh, mx)**2
        