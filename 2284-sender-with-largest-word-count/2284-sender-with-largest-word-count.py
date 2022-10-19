class Solution:
    def largestWordCount(self, messages: List[str], senders: List[str]) -> str:
        c = collections.defaultdict(int)
        maxi=-1
        ans=chr(ord('A')-1)
        
        for m in range(len(messages)):
            c[senders[m]] += len(messages[m].split())
            if c[senders[m]] > maxi:
                maxi = c[senders[m]]
                ans =  senders[m]
            elif c[senders[m]] == maxi:
                ans =  max(ans, senders[m])
        
        return ans