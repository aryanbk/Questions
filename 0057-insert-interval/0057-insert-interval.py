class Solution:
    def insert(self, intvl: List[List[int]], new: List[int]) -> List[List[int]]:
        intvl.append(new)
        intvl.sort()
        st, end = intvl[0]
        ans=[]
        for i in range(1, len(intvl)):
            if intvl[i][0]<=end:
                end = max(end, intvl[i][1])
            else:
                ans.append([st, end])
                st, end = intvl[i][0], intvl[i][1]
        ans.append([st, end])
        return ans