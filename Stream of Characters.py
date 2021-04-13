from collections import deque

class StreamChecker:
    #Approach: Trie (postfix tree)
    #Time Complexity: O(n * l) for constructor initialization; O(l) for query
    #Space Complexity: O(m)
    #where, n is the number of words, and l is the average length of a word
    #and, m is the length of the longest word
    
    def __init__(self, words: List[str]):
        self.root, self.maxLength = self.buildTree(words)
        self.sb = deque()

    def query(self, letter: str) -> bool:
        if len(self.sb) == self.maxLength:
            self.sb.popleft()
        self.sb.append(letter)
        return self.search(self.sb)
        
    def buildTree(self, words):
        root = TrieNode()
        maxLength = 0
        for word in words:
            maxLength = max(maxLength, len(word))
            curr = root
            for char in reversed(word):
                idx = ord(char) - ord('a')
                if not curr.children[idx]:
                    curr.children[idx] = TrieNode()
                curr = curr.children[idx]
            curr.isEnd = True
        return root, maxLength
        
    def search(self, word):
        curr = self.root
        for char in reversed(word):
            idx = ord(char) - ord('a')
            if not curr.children[idx]:
                return False
            curr = curr.children[idx]
            if curr.isEnd:
                return True
        return False
        
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None for _ in range(26)]

# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)