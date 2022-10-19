class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        
        mp = collections.defaultdict(int)
        for w in words:
            mp[w]-=1
        
        arr = sorted([j,i] for i,j in mp.items())
        while len(arr)-k:
            arr.pop()
            
        return [j for i,j in arr]
    