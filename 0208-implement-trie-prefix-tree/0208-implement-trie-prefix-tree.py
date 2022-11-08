class Trie:

    def __init__(self):
        self.head = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.head
        for w in word:
            if not curr.char[ord(w)-97]:
                curr.char[ord(w)-97] = TrieNode()
            curr = curr.char[ord(w)-97]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        curr = self.head
        for w in word:
            if not curr.char[ord(w)-97]:
                return False
            curr = curr.char[ord(w)-97]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr = self.head
        for w in prefix:
            if not curr.char[ord(w)-97]:
                return False
            curr = curr.char[ord(w)-97]
        return True
        
        
###########################################################
        
class TrieNode:
    def __init__(self):
        self.char = [None]*26
        self.isEnd = False

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)