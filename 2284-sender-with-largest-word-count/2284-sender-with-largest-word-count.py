class Solution:
    def largestWordCount(self, messages: List[str], senders: List[str]) -> str:
        c = collections.defaultdict(int)
        maxi=-1
        ans=chr(ord('A')-1)
        
        for m in range(len(messages)):
            c[senders[m]] += messages[m].count(' ') + 1
            if c[senders[m]] > maxi or (c[senders[m]] == maxi and senders[m]>ans):
                maxi = c[senders[m]]
                ans =  senders[m]
        
        return ans