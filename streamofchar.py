'''
time complexity:O(n*avg len of char)
space complexity: O(n*avg len of char)
'''

class TrieNode:
    
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isEnd = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insertWord(self,word):
        curr = self.root
        for i in range(len(word)-1,-1,-1):
            if curr.children[ord(word[i]) - ord('a')] ==None:
                curr.children[ord(word[i]) - ord('a')] = TrieNode()
            curr = curr.children[ord(word[i]) - ord('a')] 
        curr.isEnd = True
        
class StreamChecker:

    def __init__(self, words: List[str]):
        self.t = Trie()
        self.sb = []
        for w in words:
            self.t.insertWord(w)
        

    def query(self, letter: str) -> bool:
        self.sb.append(letter)
        curr = self.t.root
        for q in range(len(self.sb)-1,-1,-1):
            if curr.children[ord(self.sb[q]) - ord('a')] ==None: return False
            curr = curr.children[ord(self.sb[q]) - ord('a')]
            if curr.isEnd == True: return True
            #curr = curr.children[ord(self.sb[q]) - ord('a')]
        return False
        


# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)