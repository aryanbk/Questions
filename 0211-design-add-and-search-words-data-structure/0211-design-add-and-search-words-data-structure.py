class WordDictionary:

    def __init__(self):
        self.head = TrieNode()
        self.memo = {}

    def addWord(self, word: str) -> None:
        curr=self.head
        for w in word:
            if not curr.char[ord(w)-97]:
                curr.char[ord(w)-97] = TrieNode()
            curr = curr.char[ord(w)-97]
        curr.isEnd=True
        self.memo.clear()

    def search(self, word: str) -> bool:
        def dfs(ptr, curr):
            if curr==None:
                return False
            if ptr>=len(word):
                return curr.isEnd
            
            if word[ptr]=='.':
                res, i = False, 0
                while (not res) and i<26:
                    res = res or dfs(ptr+1, curr.char[i])
                    i+=1
                return res
            else:
                return dfs(ptr+1, curr.char[ord(word[ptr])-97])
        
        if word in self.memo:
            return self.memo[word]
        ans = dfs(0, self.head)
        self.memo[word] = ans
        return ans
        
class TrieNode():
    def __init__(self):
        self.char=[None]*26
        self.isEnd=False

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)