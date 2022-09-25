# Reverse the words so that instead of searching for suffix we need to search for prefix which is comparatively easy.
class TrieNode:
    def __init__(self):
        self.children = {}
        self.endOfWord = False

class Trie:
    def __init__(self):
        self.root = self.getTrieNode()
    
    def getTrieNode(self):
        return TrieNode()
    
    def insert(self, word):
        root = self.root
        for ch in word:
            if ch not in root.children:
                root.children[ch] = self.getTrieNode()
            root = root.children[ch]
        root.endOfWord = True
    
    def isPrefix(self, word):
        root = self.root
        for i in range(len(word)-1,-1,-1):
            if root.endOfWord:
                return True
            if word[i] not in root.children:
                return False
            root = root.children[word[i]]
        return root.endOfWord
        
class StreamChecker:
    def __init__(self, words: List[str]): #O(Length of all the words)
        self.stream = []
        self.trie = Trie()
        for word in words:
            
            self.trie.insert(word[::-1])
 
    def query(self, letter: str) -> bool: #O(1)
        self.stream.append(letter)
        return self.trie.isPrefix(self.stream)