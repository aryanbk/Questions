class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        ans=[]
        list1=[1]
        ans.append(list1)
        for i in range(1, numRows):
            list2=[]
            list2.append(1)
            for j in range(1,i):
                list2.append(ans[i-1][j]+ans[i-1][j-1])
            list2.append(1)
            ans.append(list2)
        return ans