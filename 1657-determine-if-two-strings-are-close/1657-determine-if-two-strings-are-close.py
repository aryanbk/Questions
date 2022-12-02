class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        if len(word1)!=len(word2): return False
        a, b = Counter(word1), Counter(word2)
        if len(a) != len(b) or set(list(a.keys())) != set(list(b.keys())): return False
        
        d = defaultdict(int)
        for ak, bk  in zip(a.keys(), b.keys()):
            if a[ak] != b[bk]:
                d[a[ak]] += 1
                d[b[bk]] -= 1
        
        for val in d.values():
            if val!=0: return False
        
        return True
        