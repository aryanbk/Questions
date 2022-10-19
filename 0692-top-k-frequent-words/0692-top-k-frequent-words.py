class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        c = Counter(words)
        hp = []
        
        for w,cnt in c.items():
            heappush(hp, Pair(cnt, w))
            if len(hp)>k:
                heappop(hp)
        
        return [pair.word for pair in sorted(hp)][::-1]

    
class Pair:
    def __init__(self, cnt, word):
        self.cnt = cnt
        self.word = word
    
    def __lt__(self, other):
        if self.cnt==other.cnt:
            return self.word > other.word
        return self.cnt < other.cnt
    
    
# class Solution:
#     def topKFrequent(self, words: List[str], k: int) -> List[str]:
        
#         mp = collections.defaultdict(int)
#         for w in words:
#             mp[w]-=1
        
#         arr = sorted([j,i] for i,j in mp.items())
#         while len(arr)-k:
#             arr.pop()
            
#         return [j for i,j in arr]
    