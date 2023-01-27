class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        words.sort(key=lambda x: len(x))
        root, ans = Trie(), []

        for w in words:
            if root.search(w): ans.append(w)
            else: root.insert(w)

        return ans

class TrieNode:
    def __init__(self):
        self.child = [None]*26
        self.end = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        ptr = self.root

        for i in range(len(word)):
            idx = ord(word[i]) - 97
            
            if not ptr.child[idx]:
                ptr.child[idx] = TrieNode()
            ptr = ptr.child[idx]
        
        ptr.end = True

    def search(self, word):
        if not word: return True
        ptr = self.root
        
        for i in range(len(word)):
            idx = ord(word[i]) - ord('a')
            if ptr.end:
                if self.search(word[i:]): return True
                
            if not ptr.child[idx]: return False
            ptr = ptr.child[idx]
            
        return ptr.end
    
    
    

    
# class Solution:
#     def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
#         words.sort(key=lambda x: len(x))
#         # print(words)
#         ans = []
#         root = Trie()
#         for w in words:
#             if root.search(w):
#                 ans.append(w)
#             else:
#                 root.add(w)
#         # print(len(ans))
#         return ans

# class TrieNode:
#     def __init__(self):
#         self.child = [None]*26
#         self.end = False

# class Trie:
#     def __init__(self):
#         self.root = TrieNode()
    
#     def add(self, word):
#         ptr = self.root
#         # print(self.root.child)
#         for i in range(len(word)):
#             idx = ord(word[i]) - 97
#             # print(i)
#             if ptr.child[idx] == None:
#                 ptr.child[idx] = TrieNode()
#             ptr = ptr.child[idx]
#         ptr.end = True
    
#     def search(self, word):
#         if not word:
#             return True
#         ptr = self.root
#         ans = False
#         for i in range(len(word)):
#             idx = ord(word[i]) - ord('a')
#             if ptr.end:
#                 ans = ans or self.search(word[i:])
#                 if ans: return ans
#             if not ptr.child[idx]:
#                 return False
#             ptr = ptr.child[idx]
#         return ptr.end or ans