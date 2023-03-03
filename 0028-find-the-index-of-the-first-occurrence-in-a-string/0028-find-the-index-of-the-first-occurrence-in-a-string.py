class Solution:
    def strStr(self, hay: str, needle: str) -> int:
        # return haystack.find(needle)
        for i in range(len(hay)-len(needle)+1):
            if hay[i:i+len(needle)] == needle: return i
        return -1