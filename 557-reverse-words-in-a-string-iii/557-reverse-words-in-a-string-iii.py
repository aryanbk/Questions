class Solution:
    def reverseWords(self, s: str) -> str:
        arr=s.split(" ")
        for i in range(len(arr)):
            j, k = "",len(arr[i])-1
            while k>=0:
                j+=arr[i][k]
                k-=1
            arr[i]=j
        ans=" "
        return ans.join(arr)
        