class Solution:
    def frequencySort(self, s: str) -> str:
        c = Counter(s)
        a = sorted(zip(c.values(), c.keys()), reverse=True)
        ans = []
        for num, char in a:
            for n in range(num):
                ans.append(char)
            
            
        return "".join(ans)