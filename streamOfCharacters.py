# Time Complexity : O(NK)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [0 for i in range(26)]
    
        
class StreamChecker:
    def insert(self, word):
        curr = self.root
        
        for i in range(len(word)-1, -1, -1):
            c = word[i]
            if not curr.children[ord(c) - ord('a')]:
                curr.children[ord(c)-ord('a')] = TrieNode()
            curr = curr.children[ord(c)-ord('a')]
        curr.isEnd = True
        
    def __init__(self, words: List[str]):
        self.sb = []
        self.root = TrieNode()
        for word in words:
            self.insert(word)
        
            
    def query(self, letter: str) -> bool:
        curr = self.root
        self.sb.append(letter)
        
        for i in range(len(self.sb)-1,-1,-1):
            c = self.sb[i]
            if not curr.children[ord(c) - ord('a')]:
                return False
        
            curr = curr.children[ord(c) - ord('a')]
            if curr.isEnd:
                return True
        
        return False


# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)