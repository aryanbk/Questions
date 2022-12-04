class Solution:
    def isCircularSentence(self, snt: str) -> bool:
        arr = snt.split()
        for i in range(len(arr)-1):
            if arr[i][-1] != arr[i+1][0]: return False
        return arr[-1][-1]==arr[0][0]